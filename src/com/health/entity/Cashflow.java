package com.health.entity;

public class Cashflow {
    private Integer cashflowid;

    private Object accountid;

    private Long referamount;

    private Object time;

    private Short operation;

    public Integer getCashflowid() {
        return cashflowid;
    }

    public void setCashflowid(Integer cashflowid) {
        this.cashflowid = cashflowid;
    }

    public Object getAccountid() {
        return accountid;
    }

    public void setAccountid(Object accountid) {
        this.accountid = accountid;
    }

    public Long getReferamount() {
        return referamount;
    }

    public void setReferamount(Long referamount) {
        this.referamount = referamount;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public Short getOperation() {
        return operation;
    }

    public void setOperation(Short operation) {
        this.operation = operation;
    }
}