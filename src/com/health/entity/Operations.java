package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Operations {
    private Integer operationid;

    private Object operation;

    public Integer getOperationid() {
        return operationid;
    }

    public void setOperationid(Integer operationid) {
        this.operationid = operationid;
    }

    public Object getOperation() {
        return operation;
    }

    public void setOperation(Object operation) {
        this.operation = operation;
    }
}