package com.gaoshin.cloud.web.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class TaskEntity {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;

	@Column(length=64, nullable=false)
	private String name;

	@Column(length=64)
	private String jobId;

	@Column(length = 1024, nullable=false)
	private String handler;

	@Column
	private int numOfRetries = 1;

	@Column(nullable=false)
	private int execOrder;

	@Column
	private Long expectedDuration;

	@Column
	private int retryInterval = 0;

	@Column
	private boolean errorHandlingTask = false;

	@Column(length=2048)
	private String args;

	@Column
	private boolean disabled = false;

    @Lob
    private String description;
    
	public void setHandler(String handler) {
		this.handler = handler;
	}

	public String getHandler() {
		return handler;
	}

	public void setNumOfRetries(int numOfRetries) {
		this.numOfRetries = numOfRetries;
	}

	public int getNumOfRetries() {
		return numOfRetries;
	}

	public void setExpectedDuration(Long expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public Long getExpectedDuration() {
		return expectedDuration;
	}

	public void setRetryInterval(int retryInterval) {
		this.retryInterval = retryInterval;
	}

	public int getRetryInterval() {
		return retryInterval;
	}

	public void setErrorHandlingTask(boolean errorHandlingTask) {
		this.errorHandlingTask = errorHandlingTask;
	}

	public boolean isErrorHandlingTask() {
		return errorHandlingTask;
	}

	public void setArgs(String args) {
		this.args = args;
	}

	public String getArgs() {
		return args;
	}

	public void setExecOrder(int execOrder) {
		this.execOrder = execOrder;
	}

	public int getExecOrder() {
		return execOrder;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String cronJobId) {
        this.jobId = cronJobId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
