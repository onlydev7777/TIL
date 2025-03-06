package com.jpatest.config;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.util.List;
import java.util.Locale;
import java.util.Stack;

public class CustomP6spySqlFormat implements MessageFormattingStrategy {
    // 표기에 허용되지 않는 filter
    private final List<String> DENIED_FILTERS = List.of("denied.package");

    // 표기에 허용되는 filter
    private final List<String> ALLOW_FILTERS = List.of("com.jpatest");

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        sql = formatSql(category, sql);
        if(sql.trim().isEmpty()) { // sql 이 없다면 출력하지 않아도 됨
            return "";
        }
        return String.format("[%s] | %d ms | %s", category, elapsed, sql + createStack(connectionId, elapsed));
    }

    // stack 콘솔 표기
    private String createStack(int connectionId, long elapsed) {
        Stack<String> callStack = new Stack<>();
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        for (StackTraceElement stackTraceElement : stackTrace) {
            String trace = stackTraceElement.toString();

            // trace 항목을 보고 내게 맞는 것만 필터
            if(ALLOW_FILTERS.stream().anyMatch(trace::startsWith)
                    && DENIED_FILTERS.stream().noneMatch(trace::startsWith)){
                callStack.push(trace);
            }
        }

        StringBuilder sb = new StringBuilder();
        int order = 1;
        while (!callStack.isEmpty()) {
            sb.append("\n\t\t").append(order++).append(".").append(callStack.pop());
        }

        return "\n\n\tConnection ID:" + connectionId +
                " | Excution Time:" + elapsed + " ms\n" +
                "\n\tExcution Time:" + elapsed + " ms\n" +
                "\n\tCall Stack :" + sb + "\n" +
                "\n--------------------------------------";
    }

    private String formatSql(String category,String sql) {
        if(sql ==null || sql.trim().equals("")) return sql;

        // Only format Statement, distinguish DDL And DML
        if (Category.STATEMENT.getName().equals(category)) {
            String tmpsql = sql.trim().toLowerCase(Locale.ROOT);
            if(tmpsql.startsWith("create") || tmpsql.startsWith("alter") || tmpsql.startsWith("comment")) {
                sql = FormatStyle.DDL.getFormatter().format(sql);
            }else {
                sql = FormatStyle.BASIC.getFormatter().format(sql);
            }
        }

        return sql;
    }
}

