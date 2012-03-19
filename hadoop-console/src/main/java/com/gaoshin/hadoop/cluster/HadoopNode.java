package com.gaoshin.hadoop.cluster;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@XmlRootElement
public class HadoopNode {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;

    @Column(length=64)
    private String clusterId;

    @Column(length=128)
    private String hostName;

    @Column(length=64)
    @Enumerated(EnumType.STRING)
    private NodeType type;

    @Column(length=64)
    @Enumerated(EnumType.STRING)
    private NodeType status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public NodeType getStatus() {
        return status;
    }

    public void setStatus(NodeType status) {
        this.status = status;
    }

}
