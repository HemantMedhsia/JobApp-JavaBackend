package com.hemant.jobapp.controller;
import com.hemant.jobapp.dto.ApiResponse;
import com.hemant.jobapp.dto.ResponseStructure;
import com.hemant.jobapp.model.JobAppModel;
import com.hemant.jobapp.service.JobAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1/jobApp")
public class JobAppController {

    JobAppService jobAppService;

    @Autowired
    public void setJobAppService(JobAppService jobAppService) {
        this.jobAppService = jobAppService;
    }

    @GetMapping("/all-jobs")
    public ResponseEntity<ResponseStructure<List<JobAppModel>>> getAllJobs() {
//        System.out.println(6/0);
        List<JobAppModel> jobs = jobAppService.AllJobs();
        return ApiResponse.success(jobs,"Data Fetched Successfully", HttpStatus.OK);
    }
}