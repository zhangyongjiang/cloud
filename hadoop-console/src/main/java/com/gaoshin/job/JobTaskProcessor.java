package com.gaoshin.job;

import com.gaoshin.cloud.web.job.entity.JobExecutionEntity;
import com.gaoshin.cloud.web.job.entity.TaskEntity;
import com.gaoshin.cloud.web.job.entity.TaskExecutionEntity;
import com.gaoshin.job.bean.GaoshinProcess;
import com.gaoshin.job.bean.TaskProcessor;
import com.gaoshin.job.plugin.BaseTaskProcessor;

public class JobTaskProcessor extends BaseTaskProcessor implements TaskProcessor {

    @Override
    public String getName() {
        return "Job Task";
    }

    @Override
    protected GaoshinProcess getProcess(JobExecutionEntity jee, TaskEntity te, TaskExecutionEntity tee) {
        return null;
    }

}