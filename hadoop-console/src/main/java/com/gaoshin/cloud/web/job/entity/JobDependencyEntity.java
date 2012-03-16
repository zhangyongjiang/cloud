package com.gaoshin.cloud.web.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class JobDependencyEntity {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;

	@Column(nullable=false, length=64)
	private String jobId;

	@Column(nullable=false, length=64)
	private String upstreamJobId;

	@Column(nullable=false)
	private long timeDiff;

	public void setTimeDiff(long timeDiff) {
		this.timeDiff = timeDiff;
	}

	public long getTimeDiff() {
		return timeDiff;
	}

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUpstreamJobId() {
        return upstreamJobId;
    }

    public void setUpstreamJobId(String upstreamJobId) {
        this.upstreamJobId = upstreamJobId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
