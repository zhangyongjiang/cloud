package com.gaoshin.cloud.web.job.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class TaskConfEntity {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;
    
	@Column(length=32)
	private String name;
	
	@Column(length=2047)
	private String value;
	
	@Column
	private boolean password = false;
	
	@Column(nullable = false, length=64)
	private String taskId;

	public TaskConfEntity() {
	}
	
	public TaskConfEntity(String key, String value) {
		this.name = key;
		this.value = value;
	}
	
	public void setPassword(boolean isPassword) {
		this.password = isPassword;
	}

	public boolean isPassword() {
		return password;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

}
