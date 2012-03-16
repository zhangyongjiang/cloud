package com.gaoshin.hadoop.installation;

import org.junit.Assert;
import org.junit.Test;

import common.util.ssh.SshShell;

public class DownloadInstallerTest {
    @Test
    public void test() throws Exception {
        DownloadInstaller installer = new DownloadInstaller();
        SshShell shell = new SshShell("192.168.2.50", "root", "r3dmine!");
        installer.setShell(shell);
        installer.setUrl("http://www.google.com/");
        installer.setDestination("/tmp/google");
        boolean success = installer.download();
        Assert.assertTrue(success);
        
        installer.setUrl("swww.goooooooooogle.comd/");
        installer.setDestination("/tmp/google");
        success = installer.download();
        Assert.assertTrue(!success);
    }
}
