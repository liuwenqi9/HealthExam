package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Guideitemsview {
    private Integer guideid;

    private Short state;

    private Object time;

    private Integer personinfoid;

    private Object allsummary;

    private Object overtime;

    private Integer guideitemid;

    private Object summary;

    private Object examtime;

    private Integer itemid;

    private Object itemname;

    private Long cost;

    private Integer deptid;

    private Object deptname;

    public Integer getGuideid() {
        return guideid;
    }

    public void setGuideid(Integer guideid) {
        this.guideid = guideid;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }

    public Integer getPersoninfoid() {
        return personinfoid;
    }

    public void setPersoninfoid(Integer personinfoid) {
        this.personinfoid = personinfoid;
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

    public Integer getGuideitemid() {
        return guideitemid;
    }

    public void setGuideitemid(Integer guideitemid) {
        this.guideitemid = guideitemid;
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

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Object getDeptname() {
        return deptname;
    }

    public void setDeptname(Object deptname) {
        this.deptname = deptname;
    }
}