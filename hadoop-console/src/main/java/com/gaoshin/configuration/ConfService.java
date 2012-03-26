package com.gaoshin.configuration;

import java.util.List;

import com.gaoshin.job.bean.JobConf;


public interface ConfService {
    JobConf getByKey(String key);
    List<JobConf> list(String ownerId);
    void remove(String confid);
    JobConf get(String confid);
    JobConf set(JobConf conf);
}
