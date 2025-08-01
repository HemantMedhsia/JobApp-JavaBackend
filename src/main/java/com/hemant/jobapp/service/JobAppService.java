package com.hemant.jobapp.service;

import com.hemant.jobapp.model.JobAppModel;

import java.util.List;

public interface JobAppService {
    List<JobAppModel> AllJobs();
    JobAppModel SearchJobWithId(int jobId);
    JobAppModel AddNewJob(JobAppModel jobAppModel);
    JobAppModel UpdateJob(JobAppModel jobAppModel);
    JobAppModel DeleteJob(int jobId);
}
