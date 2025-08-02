package com.hemant.jobapp.repo;

import com.hemant.jobapp.model.JobAppModel;

import java.util.ArrayList;
import java.util.List;

public interface JobAppRepo {
    public List<JobAppModel> getAllJobs();
    public JobAppModel findJobById(int jobId);
    public JobAppModel AddJob(JobAppModel jobAppModel);
    public JobAppModel UpdateJob(JobAppModel jobAppModel, int jobId);
    public JobAppModel DeleteJob(int jobId);
}
