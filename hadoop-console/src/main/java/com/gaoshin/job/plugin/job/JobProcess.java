package com.gaoshin.job.plugin.job;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.context.ApplicationContext;

import com.gaoshin.cloud.web.job.entity.JobExecutionEntity;
import com.gaoshin.cloud.web.job.entity.TaskEntity;
import com.gaoshin.cloud.web.job.entity.TaskExecutionEntity;
import com.gaoshin.job.plugin.BaseProcess;

public class JobProcess extends BaseProcess {

    public JobProcess(ApplicationContext springContext, JobExecutionEntity jee, TaskEntity te, TaskExecutionEntity tee) {
        super(springContext, jee, te, tee);
    }

    @Override
    public Integer getExitCode(boolean wait) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InputStream getInputStream() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InputStream getErrorStream() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OutputStream getOutputStream() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getProcessInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void cleanup() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void doJob(String[] args) throws Exception {
        // TODO Auto-generated method stub

    }

}
