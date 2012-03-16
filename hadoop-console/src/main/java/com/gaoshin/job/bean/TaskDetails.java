package com.gaoshin.job.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaskDetails extends Task {
    private Job job;
    private JobConfList taskConfList = new JobConfList();

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public JobConfList getTaskConfList() {
        return taskConfList;
    }

    public void setTaskConfList(JobConfList jobConfList) {
        this.taskConfList = jobConfList;
    }
}
