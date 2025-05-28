package com.multitenant.batch;

import com.multitenant.context.TenantContext;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RequiredArgsConstructor
@Component
public class DynamicSchemaManager {
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;
    private final EntityManagerFactory entityManagerFactory;

//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateSchema() {
        SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.getCurrentSession();

        if (!session.getTransaction().isActive()) {
            // 트랜잭션이 활성화되지 않으면 명시적으로 트랜잭션 시작
            Transaction tx = session.beginTransaction();
            session.doWork(connection -> connection.setSchema(TenantContext.getTenant()));
            tx.commit();
        } else {
            // 트랜잭션이 이미 활성화된 상태에서 doWork 호출
            session.doWork(connection -> connection.setSchema(TenantContext.getTenant()));
        }
    }


    public void setTenantSchema(String tenantIdentifier) {
//        setTenantSchemaForEntityManager(tenantIdentifier);
//        setTenantSchemaForJdbcTemplate(tenantIdentifier);
    }

    public void setTenantSchemaForEntityManager(String tenantIdentifier) {
        try {
            // EntityManager에서 Session을 가져옴
            if(transactionManager instanceof JpaTransactionManager jpaTransactionManager) {
                SessionFactory sessionFactory = (SessionFactory) jpaTransactionManager.getEntityManagerFactory();
                Session session = sessionFactory.openSession();

                // Connection을 얻고 동적 스키마 설정
                Connection connection = session.doReturningWork(con->con.unwrap(Connection.class));
                connection.setSchema(tenantIdentifier);  // 동적 스키마 설정

                // 동적 DataSource로 변경
                DataSource dynamicDataSource = createDynamicDataSource(connection);
                jpaTransactionManager.setDataSource(dynamicDataSource);
                System.out.println("TEST:::::dynamicDataSource:::::schemaName = " + jpaTransactionManager.getDataSource().getConnection().getSchema());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error setting dynamic schema for EntityManager", e);
        }
    }

    // 동적 DataSource 생성
    private DataSource createDynamicDataSource(Connection connection) {
        // DataSource로 변환하여 반환
        return new SingleConnectionDataSource(connection, false);
    }

    private void setTenantSchemaForJdbcTemplate(String tenantIdentifier) {
        Connection connection = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection(); // DataSource에서 커넥션 가져오기
            connection.setSchema(tenantIdentifier); // 동적 스키마 설정
        } catch (SQLException e) {
            throw new RuntimeException("Failed to set dynamic schema", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException("Failed to close connection", e);
                }
            }
        }
    }

}
