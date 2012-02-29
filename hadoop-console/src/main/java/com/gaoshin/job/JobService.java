package com.gaoshin.job;

import com.gaoshin.job.bean.Job;
import com.gaoshin.job.bean.JobConf;
import com.gaoshin.job.bean.JobConfDetails;
import com.gaoshin.job.bean.JobDependency;
import com.gaoshin.job.bean.JobDependencyDetails;
import com.gaoshin.job.bean.JobDetails;
import com.gaoshin.job.bean.JobList;
import com.gaoshin.job.bean.Task;
import com.gaoshin.job.bean.TaskDetails;

public interface JobService {

    Job create(Job job);

    JobList list();

    void delete(Long jobId);

    JobDetails getJobDetails(Long jobId);

    JobConf createJobConf(JobConf jobConf);

    JobConfDetails getJobConfDetails(Long jobConfId);

    void updateJobConfDetails(JobConf jobConf);

    void deleteJobConf(Long jobConfId);

    Task createTask(Task task);

    TaskDetails getTaskDetails(Long taskId);

    void updateTaskDetails(Task task);

    void deleteTask(Long taskId);

    JobDependency createJobDependency(JobDependency jobDependency);

    JobDependencyDetails getJobDependencyDetails(Long jobDependencyId);

    void updateJobDependencyDetails(JobDependency jobDependency);

    void deleteJobDependency(Long jobDependencyId);

    void enableJob(Long jobId, boolean enable);

    Job update(Job job);
}
