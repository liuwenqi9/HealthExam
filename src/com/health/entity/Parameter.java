package com.health.entity;

public class Parameter {
    private Integer parameterid;

    private Integer parentid;

    private Object paramname;

    public Integer getParameterid() {
        return parameterid;
    }

    public void setParameterid(Integer parameterid) {
        this.parameterid = parameterid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Object getParamname() {
        return paramname;
    }

    public void setParamname(Object paramname) {
        this.paramname = paramname;
    }
}