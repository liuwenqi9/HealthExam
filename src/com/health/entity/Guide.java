package com.health.entity;

public class Guide {
    private Integer guideid;

    private Short state;

    private Object time;

    private Integer personinfoid;

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
}