package com.multitenant.batch.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
    private String jobName;
    private Map<String, String> jobParameters;
}
