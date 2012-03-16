package com.gaoshin.job;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.CronExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoshin.cloud.web.bean.BusinessException;
import com.gaoshin.cloud.web.bean.ServiceError;
import com.gaoshin.cloud.web.job.entity.JobConfEntity;
import com.gaoshin.cloud.web.job.entity.JobDependencyEntity;
import com.gaoshin.cloud.web.job.entity.JobEntity;
import com.gaoshin.cloud.web.job.entity.TaskEntity;
import com.gaoshin.job.bean.Job;
import com.gaoshin.job.bean.JobConf;
import com.gaoshin.job.bean.JobConfDetails;
import com.gaoshin.job.bean.JobConfList;
import com.gaoshin.job.bean.JobDependency;
import com.gaoshin.job.bean.JobDependencyDetails;
import com.gaoshin.job.bean.JobDetails;
import com.gaoshin.job.bean.JobList;
import com.gaoshin.job.bean.Task;
import com.gaoshin.job.bean.TaskConfDetails;
import com.gaoshin.job.bean.TaskDetails;
import common.util.reflection.ReflectionUtil;

@Service("jobService")
@Transactional
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao jobDao;
    
    @Autowired
    private JobScheduler jobScheduler;
    
    @Override
    public Job create(Job job) {
        if(job.getCronExpression() != null && job.getCronExpression().trim().length() == 0) {
            job.setCronExpression(null);
        }
        if(job.getCronExpression() != null) {
            try {
                CronExpression ce = new CronExpression(job.getCronExpression());
            }
            catch (ParseException e) {
                throw new BusinessException(ServiceError.InvalidInput, "Invalid cron expression " + job.getCronExpression());
            }
        }
        
        JobEntity entity = ReflectionUtil.copy(JobEntity.class, job);
        jobDao.saveEntity(entity);
        job.setId(entity.getId());
        return job;
    }

    @Override
    public JobList list() {
        JobList list = new JobList();
        List<JobEntity> entities = jobDao.find(JobEntity.class, "from JobEntity");
        for(JobEntity je : entities) {
            list.getList().add(ReflectionUtil.copy(Job.class, je));
        }
        return list;
    }

    @Override
    public void delete(String jobId) {
        JobEntity jobEntity = jobDao.getEntity(JobEntity.class, jobId);
        if(jobEntity == null) {
            throw new BusinessException(ServiceError.NotFound);
        }
        List<JobDependencyEntity> downstreamJobs = jobDao.getDownstreamJobs(jobId);
        if(downstreamJobs.size() > 0) {
            throw new BusinessException(ServiceError.InvalidInput, "cannot delete job because of dependency " + jobId);
        }
        
        jobDao.deleteEntity(jobEntity);
    }
    
    private Job getJob(String jobId) {
        JobEntity jobEntity = jobDao.getEntity(JobEntity.class, jobId);
        if(jobEntity == null) {
            return null;
        }
        return ReflectionUtil.copy(Job.class, jobEntity);
    }

    @Override
    public JobDetails getJobDetails(String jobId) {
        JobEntity entity = jobDao.getEntity(JobEntity.class, jobId);
        JobDetails bean = ReflectionUtil.copy(JobDetails.class, entity);

        List<JobConfEntity> confList = jobDao.find(JobConfEntity.class, "from JobConfEntity where ownerId=?", jobId);
        for(JobConfEntity jce : confList) {
            bean.getJobConfList().getList().add(ReflectionUtil.copy(JobConf.class, jce));
        }
        
        List<TaskEntity> taskList = jobDao.find(TaskEntity.class, "from TaskEntity where jobId=?", jobId);
        for(TaskEntity te : taskList) {
            TaskDetails td = ReflectionUtil.copy(TaskDetails.class, te);
            List<JobConfEntity> taskConfs = jobDao.find(JobConfEntity.class, "from JobConfEntity where ownerId=?", te.getId());
            JobConfList taskConfList = new JobConfList();
            for(JobConfEntity jce : taskConfs) {
                taskConfList.getList().add(ReflectionUtil.copy(JobConf.class, jce));
            }
            td.setTaskConfList(taskConfList);
            bean.getTaskDetailsList().getItems().add(td);
        }
        Collections.sort(bean.getTaskDetailsList().getItems(), new Comparator<Task>() {
            @Override
            public int compare(Task arg0, Task arg1) {
                return arg0.getExecOrder() - arg1.getExecOrder();
            }
        });
        
        List<JobDependencyEntity> deps = jobDao.find(JobDependencyEntity.class, "from JobDependencyEntity where jobId=?", jobId);
        List jobIdList = new ArrayList<Long>();
        for(JobDependencyEntity dep : deps) {
            jobIdList.add(dep.getUpstreamJobId());
        }
        List<JobEntity> blockedByJobList = jobDao.in(JobEntity.class, "from JobEntity je where je.id in (:values)", jobIdList);
        Map<String, JobEntity> map = new HashMap<String, JobEntity>();
        for(JobEntity je : blockedByJobList) {
            map.put(je.getId(), je);
        }
        
        for(JobDependencyEntity dep : deps) {
            JobDependencyDetails jobDependency = ReflectionUtil.copy(JobDependencyDetails.class, dep);
            Job depJob = ReflectionUtil.copy(Job.class, map.get(dep.getUpstreamJobId()));
            jobDependency.setBlockedByJob(depJob);
            bean.getJobDependencyList().getList().add(jobDependency);
        }
        
        return bean;
    }

    @Override
    public JobConf createJobConf(JobConf jobConf) {
        JobConfEntity entity = ReflectionUtil.copy(JobConfEntity.class, jobConf);
        jobDao.saveEntity(entity);
        jobConf.setId(entity.getId());
        return jobConf;
    }

    @Override
    public JobConfDetails getJobConfDetails(String jobConfId) {
        JobConfEntity entity = jobDao.getEntity(JobConfEntity.class, jobConfId);
        JobConfDetails details = ReflectionUtil.copy(JobConfDetails.class, entity);
        details.setJob(getJob(entity.getOwnerId()));
        return details;
    }

    @Override
    public void updateJobConfDetails(JobConf jobConf) {
        JobConfEntity entity = ReflectionUtil.copy(JobConfEntity.class, jobConf);
        jobDao.merge(entity);
    }

    @Override
    public void deleteJobConf(String jobConfId) {
        JobConfEntity entity = jobDao.getEntity(JobConfEntity.class, jobConfId);
        jobDao.deleteEntity(entity);
    }

    @Override
    public Task createTask(Task task) {
        TaskEntity entity = ReflectionUtil.copy(TaskEntity.class, task);
        jobDao.saveEntity(entity);
        task.setId(entity.getId());
        return task;
    }

    @Override
    public TaskDetails getTaskDetails(String taskId) {
        TaskEntity entity = jobDao.getEntity(TaskEntity.class, taskId);
        TaskDetails details = ReflectionUtil.copy(TaskDetails.class, entity);
        details.setJob(getJob(entity.getJobId()));
        return details;
    }

    @Override
    public void updateTaskDetails(Task task) {
        TaskEntity entity = ReflectionUtil.copy(TaskEntity.class, task);
        jobDao.merge(entity);
    }

    @Override
    public void deleteTask(String taskId) {
        TaskEntity entity = jobDao.getEntity(TaskEntity.class, taskId);
        jobDao.deleteEntity(entity);
    }

    @Override
    public JobDependency createJobDependency(JobDependency jobDependency) {
        JobDependencyEntity entity = ReflectionUtil.copy(JobDependencyEntity.class, jobDependency);
        jobDao.saveEntity(entity);
        jobDependency.setId(entity.getId());
        return jobDependency;
    }

    @Override
    public JobDependencyDetails getJobDependencyDetails(String jobDependencyId) {
        JobDependencyEntity entity = jobDao.getEntity(JobDependencyEntity.class, jobDependencyId);
        JobDependencyDetails details = ReflectionUtil.copy(JobDependencyDetails.class, entity);
        details.setJob(getJob(entity.getJobId()));
        details.setBlockedByJob(getJob(entity.getUpstreamJobId()));
        return details;
    }

    @Override
    public void updateJobDependencyDetails(JobDependency jobDependency) {
        JobDependencyEntity entity = ReflectionUtil.copy(JobDependencyEntity.class, jobDependency);
        jobDao.merge(entity);
    }

    @Override
    public void deleteJobDependency(String jobDependencyId) {
        JobDependencyEntity entity = jobDao.getEntity(JobDependencyEntity.class, jobDependencyId);
        jobDao.deleteEntity(entity);
    }

    @Override
    public void enableJob(String jobId, boolean enable) {
        JobEntity entity = jobDao.getEntity(JobEntity.class, jobId);
        entity.setEnabled(enable);
        jobDao.saveEntity(entity);
        jobScheduler.enableJob(jobId, enable);
    }

    @Override
    public Job update(Job job) {
        if(job.getId() == null) {
            throw new BusinessException(ServiceError.InvalidInput, "must specify a job id for update");
        }
        if(job.getCronExpression() != null && job.getCronExpression().trim().length() == 0) {
            job.setCronExpression(null);
        }
        if(job.getCronExpression() != null) {
            try {
                CronExpression ce = new CronExpression(job.getCronExpression());
            }
            catch (ParseException e) {
                throw new BusinessException(ServiceError.InvalidInput, "Invalid cron expression " + job.getCronExpression());
            }
        }
        
        JobEntity entity = ReflectionUtil.copy(JobEntity.class, job);
        jobDao.merge(entity);
        return job;
    }

    @Override
    public TaskConfDetails getTaskConfDetails(String confId) {
        JobConfEntity entity = jobDao.getEntity(JobConfEntity.class, confId);
        TaskEntity taskEntity = jobDao.getEntity(TaskEntity.class, entity.getOwnerId());
        TaskDetails taskDetails = ReflectionUtil.copy(TaskDetails.class, taskEntity);
        taskDetails.setJob(getJob(taskEntity.getJobId()));
        TaskConfDetails details = ReflectionUtil.copy(TaskConfDetails.class, entity);
        details.setTaskDetails(taskDetails);
        return details;
    }
}
