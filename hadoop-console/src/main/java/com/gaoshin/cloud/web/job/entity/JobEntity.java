package com.gaoshin.cloud.web.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames="name")})
public class JobEntity {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;

	@Column(length=64, nullable=false)
	private String name;

	@Column(length=128)
	private String cronExpression;

	@Column(length=128)
	private String host;

	@Column
	private boolean enabled;

	@Column
	private int retention = 30;  // keep job for 30 days by default

	@Column
	private long expectedDuration;

	@Column
	private String notificationEmail;

	@Lob
	private String description;

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setRetention(int retention) {
		this.retention = retention;
	}

	public int getRetention() {
		return retention;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setExpectedDuration(long expectedDuration) {
		this.expectedDuration = expectedDuration;
	}

	public long getExpectedDuration() {
		return expectedDuration;
	}

	public void setNotificationEmail(String notificationEmail) {
		this.notificationEmail = notificationEmail;
	}

	public String getNotificationEmail() {
		return notificationEmail;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHost() {
		return host;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
