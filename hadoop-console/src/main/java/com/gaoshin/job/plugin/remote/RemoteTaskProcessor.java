package com.gaoshin.job.plugin.remote;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoshin.cloud.web.job.entity.JobExecutionEntity;
import com.gaoshin.cloud.web.job.entity.TaskEntity;
import com.gaoshin.cloud.web.job.entity.TaskExecutionEntity;
import com.gaoshin.job.bean.GaoshinProcess;
import com.gaoshin.job.plugin.BaseTaskProcessor;
import common.util.reflection.ReflectionUtil;

@Service("remoteTaskProcessor")
@Transactional
public class RemoteTaskProcessor extends BaseTaskProcessor {

    @Override
    public String getName() {
        return "Remote Task";
    }

    @Override
    protected GaoshinProcess getProcess(JobExecutionEntity jee, TaskEntity te, TaskExecutionEntity tee) {
        RemoteProcess execTask = new RemoteProcess(springContext, 
                ReflectionUtil.copy(JobExecutionEntity.class, jee), 
                ReflectionUtil.copy(TaskEntity.class, te), 
                ReflectionUtil.copy(TaskExecutionEntity.class, tee));
        processList.add(execTask);
        return execTask;
    }

}
