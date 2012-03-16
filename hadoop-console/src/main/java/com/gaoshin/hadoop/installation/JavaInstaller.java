package com.gaoshin.hadoop.installation;


public class JavaInstaller extends DownloadInstaller {
    public void install(String url) throws Exception {
        setUrl(url);
        setDestination("/tmp/java-pkg");
        download();
    }
}
