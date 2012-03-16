package com.gaoshin.job;

import com.gaoshin.job.bean.Job;
import com.gaoshin.job.bean.JobConf;
import com.gaoshin.job.bean.JobConfDetails;
import com.gaoshin.job.bean.JobDependency;
import com.gaoshin.job.bean.JobDependencyDetails;
import com.gaoshin.job.bean.JobDetails;
import com.gaoshin.job.bean.JobList;
import com.gaoshin.job.bean.Task;
import com.gaoshin.job.bean.TaskConfDetails;
import com.gaoshin.job.bean.TaskDetails;

public interface JobService {

    Job create(Job job);

    JobList list();

    void delete(String jobId);

    JobDetails getJobDetails(String jobId);

    JobConf createJobConf(JobConf jobConf);

    JobConfDetails getJobConfDetails(String jobConfId);

    void updateJobConfDetails(JobConf jobConf);

    void deleteJobConf(String jobConfId);

    Task createTask(Task task);

    TaskDetails getTaskDetails(String taskId);

    void updateTaskDetails(Task task);

    void deleteTask(String taskId);

    JobDependency createJobDependency(JobDependency jobDependency);

    JobDependencyDetails getJobDependencyDetails(String jobDependencyId);

    void updateJobDependencyDetails(JobDependency jobDependency);

    void deleteJobDependency(String jobDependencyId);

    void enableJob(String jobId, boolean enable);

    Job update(Job job);

    TaskConfDetails getTaskConfDetails(String confId);
}
