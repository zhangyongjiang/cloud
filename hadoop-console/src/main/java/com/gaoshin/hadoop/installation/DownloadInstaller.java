package com.gaoshin.hadoop.installation;

import java.io.InputStream;

import org.apache.commons.io.IOUtils;

public class DownloadInstaller extends Installer {
    private String url;
    private String destination;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean download() throws Exception {
        if(url == null)
            throw new RuntimeException("invalid url " + url);
        if(destination == null)
            throw new RuntimeException("invalid destination " + destination);
        shell.open();
        InputStream is = shell.run("curl \"" + url + "\" > " + destination);
        String output = IOUtils.toString(is);
        Integer code = shell.getExitCode();
        shell.close();
        return code != null && code == 0;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
}
