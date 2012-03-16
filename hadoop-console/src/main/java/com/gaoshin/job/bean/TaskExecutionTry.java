package com.gaoshin.job.bean;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class TaskExecutionTry {
    private String id;
    private String taskExecutionId;
    private WorkStatus status = WorkStatus.Pending;
    private Long startTime;
    private Long finishTime;
    
    public void setStatus(WorkStatus status) {
        this.status = status;
    }

    public WorkStatus getStatus() {
        return status;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Long finishTime) {
        this.finishTime = finishTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskExecutionId() {
        return taskExecutionId;
    }

    public void setTaskExecutionId(String taskExecutionId) {
        this.taskExecutionId = taskExecutionId;
    }
    
}
