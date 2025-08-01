package com.hemant.jobapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAppModel {
    private int jobId;
    private String companyName;
    private String jobName;
    private String jobDescription;
    private int jobExperience;
    private List<String> techStack;
    private String jobStartDate;
    private String jobEndDate;
}
