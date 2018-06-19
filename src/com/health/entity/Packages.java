package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;
@Component
public class Packages {
    private Integer packageid;

    private Object packdetail;

    private Object packname;

    private BigDecimal price;

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public Object getPackdetail() {
        return packdetail;
    }

    public void setPackdetail(Object packdetail) {
        this.packdetail = packdetail;
    }

    public Object getPackname() {
        return packname;
    }

    public void setPackname(Object packname) {
        this.packname = packname;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}