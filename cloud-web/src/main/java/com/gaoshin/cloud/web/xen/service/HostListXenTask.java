package com.gaoshin.cloud.web.xen.service;

import java.util.Map;
import java.util.Map.Entry;

import com.gaoshin.cloud.web.xen.bean.HostList;
import com.xensource.xenapi.Host;
import com.xensource.xenapi.Host.Record;

public class HostListXenTask extends XenTask {

    private HostList hosts;

    public HostListXenTask(String url, String user, String pwd, Long hostId) {
        super(url, user, pwd);
    }

    @Override
    protected void doTask() throws Exception {
        hosts = new HostList();
        Map<Host, Record> records = Host.getAllRecords(connection);
        for(Entry<Host, Record> entry : records.entrySet()) {
            Host host = entry.getKey();
            Record record = entry.getValue();
            com.gaoshin.cloud.web.xen.bean.Host ghost = new com.gaoshin.cloud.web.xen.bean.Host();
            hosts.getItems().add(ghost);
            ghost.setUuid(record.uuid);
            ghost.setName(record.hostname);
        }
    }

    public HostList getHosts() {
        return hosts;
    }

    public void setHosts(HostList hosts) {
        this.hosts = hosts;
    }
}
