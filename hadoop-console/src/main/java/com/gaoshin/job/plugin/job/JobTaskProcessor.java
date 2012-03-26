package com.gaoshin.job.plugin.job;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaoshin.cloud.web.job.entity.JobExecutionEntity;
import com.gaoshin.cloud.web.job.entity.TaskEntity;
import com.gaoshin.cloud.web.job.entity.TaskExecutionEntity;
import com.gaoshin.job.bean.GaoshinProcess;
import com.gaoshin.job.bean.TaskProcessor;
import com.gaoshin.job.plugin.BaseTaskProcessor;
import common.util.reflection.ReflectionUtil;

@Service("jobTaskProcessor")
@Transactional
public class JobTaskProcessor extends BaseTaskProcessor implements TaskProcessor {

    @Override
    public String getName() {
        return "Job Task";
    }

    @Override
    protected GaoshinProcess getProcess(JobExecutionEntity jee, TaskEntity te, TaskExecutionEntity tee) {
        JobProcess execTask = new JobProcess(springContext, 
                ReflectionUtil.copy(JobExecutionEntity.class, jee), 
                ReflectionUtil.copy(TaskEntity.class, te), 
                ReflectionUtil.copy(TaskExecutionEntity.class, tee));
        processList.add(execTask);
        return execTask;
    }

}
