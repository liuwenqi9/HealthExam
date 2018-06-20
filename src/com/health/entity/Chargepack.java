package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Chargepack {
    private Integer chargepackid;

    private Integer chargeid;

    private Integer packageid;

    private Integer numbers;

    public Integer getChargepackid() {
        return chargepackid;
    }

    public void setChargepackid(Integer chargepackid) {
        this.chargepackid = chargepackid;
    }

    public Integer getChargeid() {
        return chargeid;
    }

    public void setChargeid(Integer chargeid) {
        this.chargeid = chargeid;
    }

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}