package com.health.entity;

public class Location {
    private Integer locationid;

    private Integer parentid;

    private Object locationname;

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Object getLocationname() {
        return locationname;
    }

    public void setLocationname(Object locationname) {
        this.locationname = locationname;
    }
}