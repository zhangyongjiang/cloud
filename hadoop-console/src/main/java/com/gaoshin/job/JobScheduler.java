package com.gaoshin.job;

import com.gaoshin.job.bean.JobConfList;
import com.gaoshin.job.bean.JobExecution;

public interface JobScheduler {

    void enableJob(String jobId, boolean enable);

    JobExecution runJob(String jobId, JobConfList confList);

}
