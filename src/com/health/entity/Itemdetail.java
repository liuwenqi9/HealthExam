package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Itemdetail {
    private Integer itemdetailid;

    private Integer itemid;

    private Integer detailid;

    public Integer getItemdetailid() {
        return itemdetailid;
    }

    public void setItemdetailid(Integer itemdetailid) {
        this.itemdetailid = itemdetailid;
    }

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Integer getDetailid() {
        return detailid;
    }

    public void setDetailid(Integer detailid) {
        this.detailid = detailid;
    }
}