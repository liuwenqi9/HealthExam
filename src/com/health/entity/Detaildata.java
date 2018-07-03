package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
@Component
public class Detaildata {
    private Integer dataid;

    private Integer guideitemid;

    private Integer detailid;

    private BigDecimal detaildata;

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
    }

    public Integer getGuideitemid() {
        return guideitemid;
    }

    public void setGuideitemid(Integer guideitemid) {
        this.guideitemid = guideitemid;
    }

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public BigDecimal getDetaildata() {
        return detaildata;
    }

    public void setDetaildata(BigDecimal detaildata) {
        this.detaildata = detaildata;
    }
}