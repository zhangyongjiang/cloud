package com.gaoshin.job.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaskConfDetails extends JobConf {
    private TaskDetails taskDetails;

    public TaskDetails getTaskDetails() {
        return taskDetails;
    }

    public void setTaskDetails(TaskDetails taskDetails) {
        this.taskDetails = taskDetails;
    }
}
