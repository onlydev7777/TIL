package com.multitenant.batch;

import com.multitenant.context.TenantContext;
import com.multitenant.service.TeamSchemaService;
import com.multitenant.service.TempMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
@RequiredArgsConstructor
public class MemberJobConfiguration {
    private final TempMemberService tempMemberService;
    private final TeamSchemaService schemaService;
    private final DynamicSchemaManager dynamicSchemaManager;

    @Bean
    public Job tempMemberJob(Step tempMemberStep, JobRepository jobRepository) {
        return new JobBuilder("tempMemberJob", jobRepository)
                .start(tempMemberStep)
                .build();
    }

    @Bean
    public Step tempMemberStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return NoTransactionTaskletStepFactory.build("tempMemberStep", jobRepository, transactionManager,
                ((contribution, chunkContext) -> {
                    schemaService.findSchemaList().forEach(ts->{
                        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
                        transactionTemplate.execute(status -> {
                            TenantContext.setTenant(ts.getSchemaName());
                            try {
                                dynamicSchemaManager.updateSchema();
                                tempMemberService.sync(ts.getTeamName());
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                            TenantContext.clear();
                            return null;
                        });
                    });
                    return RepeatStatus.FINISHED;
                })
        );
    }

    private DataSource createDynamicDataSource(Connection connection) {
        // DataSource로 변환하여 반환
        return new SingleConnectionDataSource(connection, false);
    }
}
