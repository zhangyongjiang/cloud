package com.gaoshin.job.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TaskDetailsList {
    private List<TaskDetails> items = new ArrayList<TaskDetails>();

    public List<TaskDetails> getItems() {
        return items;
    }

    public void setItems(List<TaskDetails> items) {
        this.items = items;
    }
}
