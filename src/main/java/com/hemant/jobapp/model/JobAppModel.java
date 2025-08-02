package com.hemant.jobapp.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAppModel {


    @Positive(message = "Job ID is Required")
    private int jobId;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "Job name is required")
    private String jobName;

    @Size(max = 1000, message = "Job description cannot exceed 1000 characters")
    private String jobDescription;

    @Min(value = 0, message = "Experience cannot be negative")
    private int jobExperience;

    @NotNull(message = "Tech stack must be provided")
    @Size(min = 1, message = "At least one technology must be specified")
    private List<@NotBlank(message = "Tech stack items cannot be blank") String> techStack;

    @NotNull(message = "Job start date is required")
    private String jobStartDate;

    private String jobEndDate;
}
