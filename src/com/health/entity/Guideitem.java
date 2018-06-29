package com.health.entity;

public class Guideitem {
    private Integer guideitemid;

    private Integer guideid;

    private Integer itemid;

    private Object summary;

    private Object examtime;

    private Object pictureurl;

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
}