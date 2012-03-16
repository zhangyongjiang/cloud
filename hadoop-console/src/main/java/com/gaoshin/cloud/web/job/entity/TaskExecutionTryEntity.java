package com.gaoshin.cloud.web.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.gaoshin.job.bean.WorkStatus;
import common.util.Misc;

@Entity
@Table
public class TaskExecutionTryEntity {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;
    
    @Column(length=64)
    private String taskExecutionId;

    @Column(length = 64)
    @Enumerated(EnumType.STRING)
    private WorkStatus status = WorkStatus.Pending;

    @Column
    private Long startTime;

    @Column
    private Long finishTime;
    
    @Column
    @Lob
    private String note;
    
    @Column
    @Lob
    private String stdout;
    
    @Column
    private Integer nextTaskExecOrder;
    
    @Column
    @Lob
    private String processInfo;
    
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void appendNote(Exception e) {
        String trace = Misc.getStackTrace(e);
        if(note == null) {
            note = trace;
        }
        else {
            note = note + "\n\n" + trace;
        }
    }

    public void appendNote(String log) {
        if(note == null) {
            this.note = log;
        }
        else {
            this.note = this.note + "\n\n" + log;
        }
    }

    public String getStdout() {
        return stdout;
    }

    public void setStdout(String stdout) {
        this.stdout = stdout;
    }

    public void appendStdout(String log) {
        if(stdout == null) {
            this.stdout = log;
        }
        else {
            this.stdout = this.stdout + "\n\n" + log;
        }
    }

    public Integer getNextTaskExecOrder() {
        return nextTaskExecOrder;
    }

    public void setNextTaskExecOrder(Integer nextTaskExecOrder) {
        this.nextTaskExecOrder = nextTaskExecOrder;
    }

    public String getProcessInfo() {
        return processInfo;
    }

    public void setProcessInfo(String processInfo) {
        this.processInfo = processInfo;
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
