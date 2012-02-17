package com.gaoshin.cloud.web.xen.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MigrationRequest extends Request {
    private Long hostId;
    private String vmUuid;
    private String hostUuid;

    public String getVmUuid() {
        return vmUuid;
    }

    public void setVmUuid(String vmUuid) {
        this.vmUuid = vmUuid;
    }

    public String getHostUuid() {
        return hostUuid;
    }

    public void setHostUuid(String hostUuid) {
        this.hostUuid = hostUuid;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

}
