package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Role {
    private Integer roleid;

    private Object rolename;

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Object getRolename() {
        return rolename;
    }

    public void setRolename(Object rolename) {
        this.rolename = rolename;
    }
}