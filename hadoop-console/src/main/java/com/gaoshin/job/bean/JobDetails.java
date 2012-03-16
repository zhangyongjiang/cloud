package com.gaoshin.job.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY) 
@XmlType(propOrder="")
public class JobDetails extends Job {
    private JobConfList jobConfList = new JobConfList();
    private TaskDetailsList taskDetailsList = new TaskDetailsList();
    private JobDependencyList jobDependencyList = new JobDependencyList();

    public JobConfList getJobConfList() {
        return jobConfList;
    }

    public void setJobConfList(JobConfList jobConfList) {
        this.jobConfList = jobConfList;
    }

    public JobDependencyList getJobDependencyList() {
        return jobDependencyList;
    }

    public void setJobDependencyList(JobDependencyList jobDependencyList) {
        this.jobDependencyList = jobDependencyList;
    }

    public TaskDetailsList getTaskDetailsList() {
        return taskDetailsList;
    }

    public void setTaskDetailsList(TaskDetailsList taskDetailsList) {
        this.taskDetailsList = taskDetailsList;
    }
}
