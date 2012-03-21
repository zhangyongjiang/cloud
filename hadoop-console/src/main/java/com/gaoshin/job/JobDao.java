package com.gaoshin.job;

import java.util.List;

import com.gaoshin.cloud.web.dao.GenericDao;
import com.gaoshin.cloud.web.job.entity.JobConfEntity;
import com.gaoshin.cloud.web.job.entity.JobDependencyEntity;
import com.gaoshin.cloud.web.job.entity.JobEntity;
import com.gaoshin.cloud.web.job.entity.JobExecutionEntity;
import com.gaoshin.cloud.web.job.entity.RuntimeJobConfEntity;
import com.gaoshin.cloud.web.job.entity.TaskEntity;
import com.gaoshin.cloud.web.job.entity.TaskExecutionEntity;
import com.gaoshin.job.bean.WorkStatus;

public interface JobDao extends GenericDao {

    List<JobDependencyEntity> getDownstreamJobs(String jobId);

    List<JobExecutionEntity> getDueJobExecutions();

    List<JobEntity> getUpstreams(String jobId);

    List<JobDependencyEntity> getDependencies(String jobId);

    List<JobExecutionEntity> getJobExecution(String upstreamJobId, long upstreamStartTime, WorkStatus succeed);

    List<TaskEntity> getOrderedJobTasks(String jobId);

    List<JobConfEntity> getConfListByOwnerId(String ownerId);

    List<JobExecutionEntity> getJobExecutionList(String jobId, int offset, int size);

    List<TaskExecutionEntity> getJobExecutionChildren(String jobExecutionId);

    List<JobEntity> getEnabledCronJobs();

    JobExecutionEntity getLastCronScheduledJobExecution(String jobId);

    RuntimeJobConfEntity getJobExecutionConf(String jobExecutionId, String key);

    List<RuntimeJobConfEntity> getJobExecutionConfList(String jobExecutionId);

    List<JobExecutionEntity> getJobExecutionList(int offset, int size);
}
