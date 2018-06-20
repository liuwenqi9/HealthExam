package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Account {
    private Object account;

    private Object name;

    private Object password;

    private Short state;

    private Long amount;

    private Integer locationid;

    private Object locationname;

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public Object getLocationname() {
        return locationname;
    }

    public void setLocationname(Object locationname) {
        this.locationname = locationname;
    }
}