package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Packitem {
    private Integer packitemid;

    private Integer packageid;

    private Integer itemid;

    public Integer getPackitemid() {
        return packitemid;
    }

    public void setPackitemid(Integer packitemid) {
        this.packitemid = packitemid;
    }

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }
}