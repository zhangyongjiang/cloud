package com.gaoshin.cloud.web.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.gaoshin.job.bean.WorkStatus;
import common.util.Misc;

@Entity
public class JobExecutionEntity {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;

	@Column(nullable = false, length=64)
	private String jobId;

	@Column(length = 64)
	@Enumerated(EnumType.STRING)
	private WorkStatus status;

	@Column
	private long scheduledStartTime;

	@Column
	private Long expectedDuration;

	@Column
	private Long duration;

	@Column
	private Long startTime;

	@Transient
	private boolean changed;

	@Column
	private String notificationEmail;
	
	@Column
    @Lob
	private String note;

    @Column(nullable=false)
    private long delay;
    
    public WorkStatus getStatus() {
        return status;
    }

    public void setStatus(WorkStatus status) {
        this.status = status;
    }

    public long getScheduledStartTime() {
        return scheduledStartTime;
    }

    public void setScheduledStartTime(long scheduledStartTime) {
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

    public void appendNote(Exception e) {
        String trace = Misc.getStackTrace(e);
        if(note == null) {
            note = trace;
        }
        else {
            note = note + "\n\n" + trace;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public long getDelay() {
        return delay;
    }

    public void setDelay(long delay) {
        this.delay = delay;
    }
}
