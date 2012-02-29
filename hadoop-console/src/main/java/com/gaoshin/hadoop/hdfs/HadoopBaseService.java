package com.gaoshin.hadoop.hdfs;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.DFSClient;

public class HadoopBaseService {
    private String hdfsUrl;
    
    public String getHdfsUrl() {
        return hdfsUrl;
    }
    
    public Configuration getConf() {
        Configuration conf = new Configuration();
        conf.set("fs.default.name", getHdfsUrl());
        conf.set("hadoop.job.ugi", "hadoop");
        return conf;
    }

    public DFSClient getDfsClient() throws IOException {
        Configuration conf = getConf();
        DFSClient dfsClient = new DFSClient(conf);
        return dfsClient;
    }

    public void setHdfsUrl(String hdfsUrl) {
        this.hdfsUrl = hdfsUrl;
    }
}
