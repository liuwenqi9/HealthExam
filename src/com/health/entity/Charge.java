package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Charge {
    private Integer chargeid;

    private Object account;

    private Long amount;

    private Object pretime;

    private Object time;

    private Short state;

    public Integer getChargeid() {
        return chargeid;
    }

    public void setChargeid(Integer chargeid) {
        this.chargeid = chargeid;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Object getPretime() {
        return pretime;
    }

    public void setPretime(Object pretime) {
        this.pretime = pretime;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }
}