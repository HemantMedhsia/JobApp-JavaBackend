package com.hemant.jobapp.controller;
import com.hemant.jobapp.dto.ApiResponse;
import com.hemant.jobapp.dto.ResponseStructure;
import com.hemant.jobapp.model.JobAppModel;
import com.hemant.jobapp.service.JobAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        List<JobAppModel> jobs = jobAppService.AllJobs();
        return ApiResponse.success(jobs,"Data Fetched Successfully", HttpStatus.OK);
    }

    @GetMapping("/find-job-by-id/{id}")
    public ResponseEntity<ResponseStructure<JobAppModel>> getJobById(@PathVariable int id) {
        JobAppModel job = jobAppService.SearchJobWithId(id);
        return ApiResponse.success(job,"Data Fetched Successfully", HttpStatus.OK);
    }

    @PostMapping("/add-job")
    public ResponseEntity<ResponseStructure<JobAppModel>> addNewJob(@RequestBody JobAppModel jobAppModel) {
        JobAppModel addedJob = jobAppService.AddNewJob(jobAppModel);
        return ApiResponse.success(addedJob,"Data Added Successfully", HttpStatus.OK);
    }

    @PostMapping("/update-job-by-id/{id}")
    public ResponseEntity<ResponseStructure<JobAppModel>> updateJobWithId(@RequestBody JobAppModel jobAppModel, @PathVariable int id) {
        JobAppModel updatedJob = jobAppService.UpdateJob(jobAppModel,id);
        return ApiResponse.success(updatedJob,"Data Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-job-by-id/{id}")
    public ResponseEntity<ResponseStructure<JobAppModel>> DeleteJobWithId(@PathVariable int id) {
        System.out.println("Hitting DeleteJobWithId --------------------------------->>>>>>");
        JobAppModel deletedJob = jobAppService.DeleteJob(id);
        System.out.println("Hitting DeleteJobWithId 3333333 --------------------------------->>>>>>");
        return ApiResponse.success(deletedJob,"Data Deleted Successfully", HttpStatus.OK);
    }

}