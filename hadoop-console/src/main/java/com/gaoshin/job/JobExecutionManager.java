package com.gaoshin.job;

import com.gaoshin.cloud.web.bean.StringList;
import com.gaoshin.job.bean.JobExecutionDetails;
import com.gaoshin.job.bean.JobExecutionDetailsList;

public interface JobExecutionManager {

    StringList listTaskType();

    void taskExecutionSucceed(String currentTaskExecutionEntityId);

    void taskExecutionFailed(String id);

    void jobFailed(String jobExecutionId);

    void jobSucceed(String jobExecutionId);

    void checkDueJob();

    JobExecutionDetailsList getJobExecutionList(String jobId, int offset, int size);

    JobExecutionDetails getJobExecutionDetails(String jobExecutionId);
}
