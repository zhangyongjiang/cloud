package com.gaoshin.job.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY) 
@XmlType(propOrder="")
public class KeyValueList {
	private List<KeyValue> items = new ArrayList<KeyValue>();

    public List<KeyValue> getItems() {
        return items;
    }

    public void setItems(List<KeyValue> items) {
        this.items = items;
    }

}
