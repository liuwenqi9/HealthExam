package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Operationlog {
    private Integer operationlogid;

    private Integer operationid;

    private Integer workerid;

    private Object time;

    public Integer getOperationlogid() {
        return operationlogid;
    }

    public void setOperationlogid(Integer operationlogid) {
        this.operationlogid = operationlogid;
    }

    public Integer getOperationid() {
        return operationid;
    }

    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
    }

    public Integer getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Integer workerid) {
        this.workerid = workerid;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }
}