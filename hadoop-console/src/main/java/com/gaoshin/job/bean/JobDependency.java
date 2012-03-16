package com.gaoshin.job.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JobDependency {
    private String id;
    private String jobId;
    private String upstreamJobId;
    private long timeDiff;

    public void setTimeDiff(long timeDiff) {
        this.timeDiff = timeDiff;
    }

    public long getTimeDiff() {
        return timeDiff;
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

    public String getUpstreamJobId() {
        return upstreamJobId;
    }

    public void setUpstreamJobId(String upstreamJobId) {
        this.upstreamJobId = upstreamJobId;
    }

}
