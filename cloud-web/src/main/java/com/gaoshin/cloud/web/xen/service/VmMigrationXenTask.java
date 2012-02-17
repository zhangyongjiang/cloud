package com.gaoshin.cloud.web.xen.service;

import java.util.HashMap;
import java.util.Map;

import com.gaoshin.cloud.web.xen.bean.MigrationRequest;
import com.xensource.xenapi.Host;
import com.xensource.xenapi.VM;

public class VmMigrationXenTask extends XenTask {

    private MigrationRequest request;

    public VmMigrationXenTask(String url, String user, String pwd, MigrationRequest request) {
        super(url, user, pwd);
        this.request = request;
    }

    @Override
    protected void doTask() throws Exception {
        VM vm = VM.getByUuid(connection, request.getVmUuid());
        Host host = Host.getByUuid(connection, request.getHostUuid());
        Map<String, String> options = new HashMap<String, String>();
        vm.poolMigrate(connection, host, options);
    }
}
