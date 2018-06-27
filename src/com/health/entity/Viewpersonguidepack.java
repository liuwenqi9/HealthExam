package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Viewpersonguidepack {
    private BigDecimal rownumber;

    private Object name;

    private Object account;

    private Integer guideid;

    private Object time;

    private Short state;

    private Integer packageid;

    private Object packname;

    private BigDecimal price;

    public BigDecimal getRownumber() {
        return rownumber;
    }

    public void setRownumber(BigDecimal rownumber) {
        this.rownumber = rownumber;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public Integer getGuideid() {
        return guideid;
    }

    public void setGuideid(Integer guideid) {
        this.guideid = guideid;
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

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public Object getPackname() {
        return packname;
    }

    public void setPackname(Object packname) {
        this.packname = packname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}