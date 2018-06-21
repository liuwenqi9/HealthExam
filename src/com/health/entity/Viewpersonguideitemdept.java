
package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
@Component
public class Viewpersonguideitemdept {
    private BigDecimal rownumber;

    private Object name;

    private Object account;

    private Object time;

    private Short state;

    private Object itemname;

    private Object deptname;

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

    public Object getItemname() {
        return itemname;
    }

    public void setItemname(Object itemname) {
        this.itemname = itemname;
    }

    public Object getDeptname() {
        return deptname;
    }

    public void setDeptname(Object deptname) {
        this.deptname = deptname;
    }
}