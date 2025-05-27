package com.multitenant.batch;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.transaction.PlatformTransactionManager;

public class NoTransactionTaskletStepFactory {
    public static Step build(String stepName,
                             JobRepository jobRepository,
                             PlatformTransactionManager transactionManager,
                             Tasklet tasklet) {

        // 트랜잭션을 아예 사용하지 않도록 설정
//        DefaultTransactionAttribute noTx = new DefaultTransactionAttribute();
//        noTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);

        return new StepBuilder(stepName, jobRepository)
                .tasklet(tasklet, transactionManager)
//                .transactionAttribute(noTx)
                .build();
    }

}
