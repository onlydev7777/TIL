package _02_factory_method._03_java;

import java.util.Calendar;
import java.util.Locale;

public class CalendarExample {

  public static void main(String[] args) {
    //java 캘린더는 SimpleFactory 패턴 사용
    System.out.println(Calendar.getInstance().getClass());
    System.out.println(Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH")).getClass());
    System.out.println(Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP")).getClass());
  }

}
