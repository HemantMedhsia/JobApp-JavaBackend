package com.hemant.jobapp.serviceImpl;

import com.hemant.jobapp.model.JobAppModel;
import com.hemant.jobapp.repo.JobAppRepo;
import com.hemant.jobapp.service.JobAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAppServiceImpl implements JobAppService {

    JobAppRepo jobAppRepo;

    @Autowired
    public void setJobAppRepo(JobAppRepo jobAppRepo) {
        this.jobAppRepo = jobAppRepo;
    }

    @Override
    public List<JobAppModel> AllJobs() {
        return jobAppRepo.getAllJobs();
    }

    @Override
    public JobAppModel SearchJobWithId(int jobId) {
        return jobAppRepo.findJobById(jobId);
    }

    @Override
    public JobAppModel AddNewJob(JobAppModel jobAppModel) {
        return jobAppRepo.AddJob(jobAppModel);
    }

    @Override
    public JobAppModel UpdateJob(JobAppModel jobAppModel) {
        return jobAppRepo.UpdateJob(jobAppModel);
    }

    @Override
    public JobAppModel DeleteJob(int jobId) {
        return jobAppRepo.DeleteJob(jobId);
    }
}
