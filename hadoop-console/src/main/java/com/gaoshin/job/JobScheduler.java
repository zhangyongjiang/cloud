package com.gaoshin.job;

import com.gaoshin.job.bean.JobConfList;
import com.gaoshin.job.bean.JobExecution;

public interface JobScheduler {

    void enableJob(Long jobId, boolean enable);

    JobExecution runJob(Long jobId, JobConfList confList);

}
