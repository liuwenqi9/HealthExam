
package com.health.entity;

import org.springframework.stereotype.Component;
/**
 * 
 * @author JSY补充备注
 * @date 6月23
 *  导诊卡
 */

@Component
public class Guide {
    private Integer guideid;//导诊卡id

    private Short state;//状态

    private Object time;//开导诊卡单时间

    private Integer personinfoid;//体检者iD

    private Object allsummary;//体检总结

    private Object overtime;//体检结束时间

    private Integer chargeid;

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

    public Integer getChargeid() {
        return chargeid;
    }

    public void setChargeid(Integer chargeid) {
        this.chargeid = chargeid;
    }
}