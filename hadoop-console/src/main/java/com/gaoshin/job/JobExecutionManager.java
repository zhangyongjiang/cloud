package com.gaoshin.job;

import com.gaoshin.job.bean.JobExecutionDetails;
import com.gaoshin.job.bean.JobExecutionDetailsList;
import com.gaoshin.job.bean.KeyValueList;

public interface JobExecutionManager {

    KeyValueList listTaskType();

    void taskExecutionSucceed(String currentTaskExecutionEntityId);

    void taskExecutionFailed(String id);

    void jobFailed(String jobExecutionId);

    void jobSucceed(String jobExecutionId);

    void checkDueJob();

    JobExecutionDetailsList getJobExecutionList(String jobId, int offset, int size);

    JobExecutionDetails getJobExecutionDetails(String jobExecutionId);

    JobExecutionDetailsList getJobExecutionList(int offset, int size);
}
