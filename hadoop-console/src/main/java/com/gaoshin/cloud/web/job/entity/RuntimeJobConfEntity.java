package com.gaoshin.cloud.web.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class RuntimeJobConfEntity {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;
    
	@Column(length=32)
	private String ckey;
	
	@Column(length=2047)
	private String cvalue;
	
	@Column
	private boolean password = false;
	
	@Column(nullable = false, length=64)
	private String jobExecutionId;

	public RuntimeJobConfEntity() {
	}
	
	public RuntimeJobConfEntity(String key, String value) {
		this.ckey = key;
		this.cvalue = value;
	}
	
	public void setPassword(boolean isPassword) {
		this.password = isPassword;
	}

	public boolean isPassword() {
		return password;
	}

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public String getCvalue() {
        return cvalue;
    }

    public void setCvalue(String cvalue) {
        this.cvalue = cvalue;
    }

    public String getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(String jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
