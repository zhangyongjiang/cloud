package com.gaoshin.job.plugin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.gaoshin.cloud.web.job.entity.JobExecutionEntity;
import com.gaoshin.cloud.web.job.entity.TaskEntity;
import com.gaoshin.cloud.web.job.entity.TaskExecutionEntity;
import com.gaoshin.job.JobDao;
import com.gaoshin.job.bean.GaoshinProcess;
import com.gaoshin.job.bean.TaskProcessor;
import com.gaoshin.job.bean.WorkStatus;

public abstract class BaseTaskProcessor implements TaskProcessor, ApplicationContextAware {
    abstract protected GaoshinProcess getProcess(JobExecutionEntity jee, TaskEntity te, TaskExecutionEntity tee);
    
    @Autowired private JobDao jobDao;
    protected ApplicationContext springContext;
    
    protected List<GaoshinProcess> processList = new ArrayList<GaoshinProcess>();

    @Override
    public void setApplicationContext(ApplicationContext springContext) throws BeansException {
        this.springContext = springContext;
    }
    
    
    @Override
    public void run(JobExecutionEntity jee, TaskEntity toBeExecuted) {
        TaskExecutionEntity tee = new TaskExecutionEntity();
        tee.setJobExecutionId(jee.getId());
        tee.setArgs(toBeExecuted.getArgs());
        tee.setErrorHandlingTask(toBeExecuted.isErrorHandlingTask());
        tee.setExecOrder(toBeExecuted.getExecOrder());
        tee.setExpectedDuration(toBeExecuted.getExpectedDuration());
        tee.setHandler(toBeExecuted.getHandler());
        tee.setTaskId(toBeExecuted.getId());
        tee.setName(toBeExecuted.getName());
        tee.setNumOfRetries(toBeExecuted.getNumOfRetries());
        tee.setRetryInterval(toBeExecuted.getRetryInterval());
        tee.setStartTime(System.currentTimeMillis());
        tee.setStatus(WorkStatus.Running);
        jobDao.saveEntity(tee);
        
        GaoshinProcess process = getProcess(jee, toBeExecuted, tee);
        process.start();
    }

}
