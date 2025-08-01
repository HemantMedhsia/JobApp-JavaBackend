package com.hemant.jobapp.controller;

import com.hemant.jobapp.ApiResponse;
import com.hemant.jobapp.model.JobAppModel;
import com.hemant.jobapp.service.JobAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jobApp")
public class JobAppController {

    @Autowired
    JobAppService jobAppService;

    @GetMapping("/all-jobs")
    public ApiResponse<List<JobAppModel>> getAllJobs() {
        List<JobAppModel> jobs = jobAppService.AllJobs();
        return ApiResponse.<List<JobAppModel>>builder()
                .status("success")
                .message("Data Fetch Successfully")
                .data(jobs)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
