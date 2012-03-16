package com.gaoshin.hadoop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class HadoopCluster {
    @Id @GeneratedValue(generator="idGenerator")
    @GenericGenerator(name="idGenerator", strategy="common.db.IdGenerator")
    @Column(length=64)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
