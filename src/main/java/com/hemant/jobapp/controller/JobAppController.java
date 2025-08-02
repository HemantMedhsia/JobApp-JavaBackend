package com.hemant.jobapp.controller;
import com.hemant.jobapp.dto.ApiResponse;
import com.hemant.jobapp.dto.ResponseStructure;
import com.hemant.jobapp.model.JobAppModel;
import com.hemant.jobapp.service.JobAppService;
import jakarta.validation.Valid;
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
        if (job ==  null)
            return ApiResponse.error(null,"Job not found with id: " + id, HttpStatus.NOT_FOUND);
        return ApiResponse.success(job,"Data Fetched Successfully", HttpStatus.OK);
    }

    @PostMapping("/create-job")
    public ResponseEntity<ResponseStructure<JobAppModel>> addNewJob(@Valid @RequestBody JobAppModel jobAppModel) {
        JobAppModel addedJob = jobAppService.AddNewJob(jobAppModel);
        return ApiResponse.success(addedJob, "Job created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update-job-by-id/{id}")
    public ResponseEntity<ResponseStructure<JobAppModel>> updateJobWithId(@Valid @RequestBody JobAppModel jobAppModel, @PathVariable int id) {
        JobAppModel isExisting = jobAppService.SearchJobWithId(id);
        if (isExisting ==  null) {
            return ApiResponse.error(null,"Cannot update. Job not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        JobAppModel updatedJob = jobAppService.UpdateJob(jobAppModel,id);
        return ApiResponse.success(updatedJob,"Job Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-job-by-id/{id}")
    public ResponseEntity<ResponseStructure<JobAppModel>> DeleteJobWithId(@PathVariable int id) {
        boolean isDeleted = jobAppService.DeleteJob(id);
        if (!isDeleted) {
            return ApiResponse.error(null,"Unable to delete job with id: " + id, HttpStatus.BAD_REQUEST);
        }
        return ApiResponse.success(null, "Job deleted successfully", HttpStatus.NO_CONTENT);
    }

}