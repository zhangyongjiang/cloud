package com.gaoshin.job.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JobExecution {
	private String id;
	private String jobId;
	private WorkStatus status;
	private Long scheduledStartTime;
	private Long expectedDuration;
	private Long duration;
	private Long startTime;
	private boolean changed;
	private String notificationEmail;
    private String note;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public WorkStatus getStatus() {
        return status;
    }

    public void setStatus(WorkStatus status) {
        this.status = status;
    }

    public Long getScheduledStartTime() {
        return scheduledStartTime;
    }

    public void setScheduledStartTime(Long scheduledStartTime) {
        this.scheduledStartTime = scheduledStartTime;
    }

    public Long getExpectedDuration() {
        return expectedDuration;
    }

    public void setExpectedDuration(Long expectedDuration) {
        this.expectedDuration = expectedDuration;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public String getNotificationEmail() {
        return notificationEmail;
    }

    public void setNotificationEmail(String notificationEmail) {
        this.notificationEmail = notificationEmail;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
