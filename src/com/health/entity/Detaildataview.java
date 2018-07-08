package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
@Component
public class Detaildataview {
    private Integer itemid;

    private Object itemname;

    private Integer guideitemid;

    private Integer guideid;

    private Object summary;

    private Object examtime;

    private Object pictureurl;

    private Integer dataid;

    private Integer detailid;

    private BigDecimal detaildata;

    private Object name;

    private BigDecimal uplimit;

    private BigDecimal lowlimit;

    private Integer parameterid;

    private Object paramname;

    private Integer itemdetailid;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Object getItemname() {
        return itemname;
    }

    public void setItemname(Object itemname) {
        this.itemname = itemname;
    }

    public Integer getGuideitemid() {
        return guideitemid;
    }

    public void setGuideitemid(Integer guideitemid) {
        this.guideitemid = guideitemid;
    }

    public Integer getGuideid() {
        return guideid;
    }

    public void setGuideid(Integer guideid) {
        this.guideid = guideid;
    }

    public Object getSummary() {
        return summary;
    }

    public void setSummary(Object summary) {
        this.summary = summary;
    }

    public Object getExamtime() {
        return examtime;
    }

    public void setExamtime(Object examtime) {
        this.examtime = examtime;
    }

    public Object getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(Object pictureurl) {
        this.pictureurl = pictureurl;
    }

    public Integer getDataid() {
        return dataid;
    }

    public void setDataid(Integer dataid) {
        this.dataid = dataid;
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

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
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

    public Integer getParameterid() {
        return parameterid;
    }

    public void setParameterid(Integer parameterid) {
        this.parameterid = parameterid;
    }

    public Object getParamname() {
        return paramname;
    }

    public void setParamname(Object paramname) {
        this.paramname = paramname;
    }

    public Integer getItemdetailid() {
        return itemdetailid;
    }

    public void setItemdetailid(Integer itemdetailid) {
        this.itemdetailid = itemdetailid;
    }
}