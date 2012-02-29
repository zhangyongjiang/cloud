package com.gaoshin.job;

import com.gaoshin.cloud.web.bean.StringList;
import com.gaoshin.job.bean.JobExecutionDetails;
import com.gaoshin.job.bean.JobExecutionDetailsList;

public interface JobExecutionManager {

    StringList listTaskType();

    void taskExecutionSucceed(Long currentTaskExecutionEntityId);

    void taskExecutionFailed(Long id);

    void jobFailed(Long jobExecutionId);

    void jobSucceed(Long jobExecutionId);

    void checkDueJob();

    JobExecutionDetailsList getJobExecutionList(Long jobId);

    JobExecutionDetails getJobExecutionDetails(Long jobExecutionId);
}
