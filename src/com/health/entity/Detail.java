package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
@Component
public class Detail {
    private Integer detailid;

    private Object name;

    private Integer paramid;

    private BigDecimal uplimit;

    private BigDecimal lowlimit;

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Integer getParamid() {
        return paramid;
    }

    public void setParamid(Integer paramid) {
        this.paramid = paramid;
    }

    public BigDecimal getUplimit() {
        return uplimit;
    }

    public void setUplimit(BigDecimal uplimit) {
        this.uplimit = uplimit;
    }

    public BigDecimal getLowlimit() {
        return lowlimit;
    }

    public void setLowlimit(BigDecimal lowlimit) {
        this.lowlimit = lowlimit;
    }
}