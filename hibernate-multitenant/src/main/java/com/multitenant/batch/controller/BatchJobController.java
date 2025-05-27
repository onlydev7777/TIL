package com.multitenant.batch.controller;

import com.multitenant.batch.dto.JobRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/batch")
@RestController
public class BatchJobController {
    private final JobLauncher jobLauncher;
    private final JobRegistry jobRegistry;

    @PostMapping("/start")
    public ResponseEntity<String> startJob(@RequestBody JobRequest jobRequest) {
        log.info("jobName: {}", jobRegistry.getJobNames());
        String jobName = jobRequest.getJobName();
        Map<String, String> allParams = jobRequest.getJobParameters();
        try {
            Job job = jobRegistry.getJob(jobName);

            JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
            jobParametersBuilder.addString("jobName", jobName);
            jobParametersBuilder.addString("runId", UUID.randomUUID().toString());
            allParams.forEach(jobParametersBuilder::addString);
            JobParameters jobParameters = jobParametersBuilder.toJobParameters();
            JobExecution jobExecution = jobLauncher.run(job, jobParameters);


            return ResponseEntity.ok("Job started successfully with status: " + jobExecution.getStatus());

        } catch (NoSuchJobException e) {
            return ResponseEntity.status(404).body("Job not found: " + jobName);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Job failed to start: " + e.getMessage());
        }
    }
}
