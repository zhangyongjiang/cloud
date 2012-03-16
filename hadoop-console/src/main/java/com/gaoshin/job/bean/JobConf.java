package com.gaoshin.job.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JobConf {
    private String id;
	private String ckey;
	private String cvalue;
	private boolean password = false;
	private String jobId;

	public JobConf() {
	}
	
	public JobConf(String key, String value) {
		this.ckey = key;
		this.cvalue = value;
	}
	
	public void setPassword(boolean isPassword) {
		this.password = isPassword;
	}

	public boolean isPassword() {
		return password;
	}

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String cronJobId) {
        this.jobId = cronJobId;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
