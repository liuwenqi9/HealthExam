package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Examreport {
    private Integer guideid;

    private Object guidetime;

    private Object allsummary;

    private Object overtime;

    private Integer itemid;

    private Object summary;

    private Object pictureurl;

    private Integer deptid;

    private Object itemname;

    private Integer detailid;

    private Object detailname;

    private BigDecimal uplimit;

    private BigDecimal lowlimit;

    private Integer parameterid;

    private Object paramname;
    
    private Object deptname;

    public Object getDeptname() {
		return deptname;
	}

	public void setDeptname(Object deptname) {
		this.deptname = deptname;
	}

	public Integer getGuideid() {
        return guideid;
    }

    public void setGuideid(Integer guideid) {
        this.guideid = guideid;
    }

    public Object getGuidetime() {
        return guidetime;
    }

    public void setGuidetime(Object guidetime) {
        this.guidetime = guidetime;
    }

    public Object getAllsummary() {
        return allsummary;
    }

    public void setAllsummary(Object allsummary) {
        this.allsummary = allsummary;
    }

    public Object getOvertime() {
        return overtime;
    }

    public void setOvertime(Object overtime) {
        this.overtime = overtime;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Object getSummary() {
        return summary;
    }

    public void setSummary(Object summary) {
        this.summary = summary;
    }

    public Object getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(Object pictureurl) {
        this.pictureurl = pictureurl;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Object getItemname() {
        return itemname;
    }

    public void setItemname(Object itemname) {
        this.itemname = itemname;
    }

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }

    public Object getDetailname() {
        return detailname;
    }

    public void setDetailname(Object detailname) {
        this.detailname = detailname;
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
}