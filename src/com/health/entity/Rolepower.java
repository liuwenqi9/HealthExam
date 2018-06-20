package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Rolepower {
    private Integer rolepowerid;

    private Integer roleid;

    private Integer menuid;

    public Integer getRolepowerid() {
        return rolepowerid;
    }

    public void setRolepowerid(Integer rolepowerid) {
        this.rolepowerid = rolepowerid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }
}