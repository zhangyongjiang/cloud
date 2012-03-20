package com.gaoshin.job.plugin.remote;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.gaoshin.cloud.web.job.entity.JobExecutionEntity;
import com.gaoshin.cloud.web.job.entity.TaskEntity;
import com.gaoshin.cloud.web.job.entity.TaskExecutionEntity;
import com.gaoshin.job.plugin.BaseProcess;
import common.util.ssh.SshShell;

public class RemoteProcess extends BaseProcess {
    public static final String ParamHost = "Host";
    public static final String ParamUser = "User";
    public static final String ParamPassword = "Password";
    public static final String ParamPrivateKey = "PrivateKey";
    
    private SshShell sshShell;

    public RemoteProcess(ApplicationContext springContext, JobExecutionEntity jee, TaskEntity te, TaskExecutionEntity tee) {
        super(springContext, jee, te, tee);
    }

    @Override
    public void start() {
        Map<String, String> confs = getConfigurations();
        String host = confs.get(ParamHost);
        String user = confs.get(ParamUser);
        String password = confs.get(ParamPassword);
        String privateKey = confs.get(ParamPrivateKey);
        try {
            if(user != null) {
                sshShell = new SshShell(host, user, password);
            }
            else {
                sshShell = new SshShell(host, privateKey.getBytes());
            }
            sshShell.open();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

        super.start();
    }

    public void doJob(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        for(String s : args) {
            sb.append(s).append(" ");
        }
        String cmd = sb.toString();
        sshShell.run(cmd);
    }

    @Override
    public Integer getExitCode(boolean wait) throws Exception {
        return sshShell.getExitCode();
    }

    @Override
    public InputStream getInputStream() {
        return sshShell.getInputStream();
    }

    @Override
    public OutputStream getOutputStream() {
        return sshShell.getOutputStream();
    }

    @Override
    public String getProcessInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InputStream getErrorStream() throws IOException {
        return sshShell.getStderrInputStream();
    }

    @Override
    public void cleanup() {
        try {
            sshShell.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
