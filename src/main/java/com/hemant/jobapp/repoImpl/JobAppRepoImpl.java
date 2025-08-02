package com.hemant.jobapp.repoImpl;

import com.hemant.jobapp.model.JobAppModel;
import com.hemant.jobapp.repo.JobAppRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JobAppRepoImpl implements JobAppRepo {
List<JobAppModel> jobAppModels = new ArrayList<>();

    @PostConstruct
    public void initFakeData() {
        jobAppModels.add(new JobAppModel(
                1,
                "TechCorp",
                "Backend Developer",
                "Develop REST APIs",
                2, // 2 years experience
                List.of("Java", "Spring Boot", "MongoDB"),
                "2023-01-10",
                "2024-01-10"
        ));

        jobAppModels.add(new JobAppModel(
                2,
                "UIWorks",
                "Frontend Engineer",
                "Build interactive UIs",
                1, // 1 year experience
                List.of("React", "TypeScript", "Tailwind"),
                "2022-06-01",
                "2023-06-01"
        ));

        jobAppModels.add(new JobAppModel(
                3,
                "StartupX",
                "Fullstack Intern",
                "End-to-end feature delivery",
                0, // internship, treat as 0 years
                List.of("React", "Node.js", "Express"),
                "2024-02-15",
                "2024-08-15"
        ));

        jobAppModels.add(new JobAppModel(
                4,
                "ScaleUp",
                "SDE-I",
                "Core platform development",
                3, // 3 years
                List.of("Java", "Microservices", "Docker"),
                "2021-09-01",
                "2023-09-01"
        ));

        jobAppModels.add(new JobAppModel(
                5,
                "InfraEdge",
                "DevOps Engineer",
                "CI/CD pipelines and infra",
                2, // 2 years
                List.of("Kubernetes", "Jenkins", "AWS"),
                "2023-03-20",
                "2024-03-20"
        ));

        jobAppModels.add(new JobAppModel(
                6,
                "DataFlow Labs",
                "Data Engineer",
                "ETL and data pipelines",
                1, // 1 year
                List.of("Python", "Airflow", "BigQuery"),
                "2024-01-05",
                "2025-01-05"
        ));
    }


    @Override
    public List<JobAppModel> getAllJobs() {
        return jobAppModels;
    }

    @Override
    public JobAppModel findJobById(int jobId) {
        for(JobAppModel jobAppModel: jobAppModels) {
            if(jobAppModel.getJobId() == jobId) {
                return jobAppModel;
            }
        }
        return null;
    }

    @Override
    public JobAppModel AddJob(JobAppModel jobAppModel) {
        jobAppModels.add(jobAppModel);
        return findJobById(jobAppModel.getJobId());
    }

    @Override
    public JobAppModel UpdateJob(JobAppModel jobAppModel, int id) {
        for(JobAppModel job: jobAppModels) {
            if(job.getJobId() == id) {
                job.setJobName(jobAppModel.getJobName());
                job.setJobDescription(jobAppModel.getJobDescription());
                job.setJobExperience(jobAppModel.getJobExperience());
                job.setTechStack(jobAppModel.getTechStack());
                job.setCompanyName(jobAppModel.getCompanyName());
                job.setJobStartDate(jobAppModel.getJobStartDate());
                job.setJobEndDate(jobAppModel.getJobEndDate());
            }
        }
        return findJobById(id);
    }

    @Override
    public JobAppModel DeleteJob(int jobId) {
        for(JobAppModel job: jobAppModels) {
            if(job.getJobId() == jobId) {
                jobAppModels.remove(job);
                return findJobById(jobId);
            }
        }
        return null;
    }
}
