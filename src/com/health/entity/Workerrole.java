package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Workerrole {
    private Integer workerroleid;

    private Integer workerid;

    private Integer roleid;

    public Integer getWorkerroleid() {
        return workerroleid;
    }

    public void setWorkerroleid(Integer workerroleid) {
        this.workerroleid = workerroleid;
    }

    public Integer getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Integer workerid) {
        this.workerid = workerid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}