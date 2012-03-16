package com.gaoshin.hadoop.installation;

import common.util.ssh.SshShell;

public class Installer {
    private String location;
    protected SshShell shell;

    public SshShell getShell() {
        return shell;
    }

    public void setShell(SshShell shell) {
        this.shell = shell;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
