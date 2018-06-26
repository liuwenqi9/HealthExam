package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Mysettleview {
    private Integer chargeid;

    private Object companyacc;

    private Long amount;

    private Object recordtime;

    private Integer recordstate;

    private Integer pid;

    private Object pname;

    private Object identity;

    private BigDecimal barcode;

    private Object companyname;

    private Integer guideid;

    private Integer guidestate;

    private Object allsummary;

    private Object packname;

    private BigDecimal price;
    
    private Integer gnumber; //实检人数
    
    private Integer pnumber; //下单人数
    
    private Integer totalprice; //总价格

    public Integer getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}

	public void setPname(Object pname) {
		this.pname = pname;
	}

	public Integer getChargeid() {
        return chargeid;
    }

    public void setChargeid(Integer chargeid) {
        this.chargeid = chargeid;
    }

    public Integer getGnumber() {
		return gnumber;
	}

	public void setGnumber(Integer gnumber) {
		this.gnumber = gnumber;
	}

	public Integer getPnumber() {
		return pnumber;
	}

	public void setPnumber(Integer pnumber) {
		this.pnumber = pnumber;
	}

	public Object getCompanyacc() {
        return companyacc;
    }

    public void setCompanyacc(Object companyacc) {
        this.companyacc = companyacc;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Object getRecordtime() {
        return recordtime;
    }

    public void setRecordtime(Object recordtime) {
        this.recordtime = recordtime;
    }

    public Integer getRecordstate() {
        return recordstate;
    }

    public void setRecordstate(Integer recordstate) {
        this.recordstate = recordstate;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Object getPname() {
        return pname;
    }

    public void setPname(Integer pname) {
        this.pname = pname;
    }

    public Object getIdentity() {
        return identity;
    }

    public void setIdentity(Object identity) {
        this.identity = identity;
    }

    public BigDecimal getBarcode() {
        return barcode;
    }

    public void setBarcode(BigDecimal barcode) {
        this.barcode = barcode;
    }

    public Object getCompanyname() {
        return companyname;
    }

    public void setCompanyname(Object companyname) {
        this.companyname = companyname;
    }

    public Integer getGuideid() {
        return guideid;
    }

    public void setGuideid(Integer guideid) {
        this.guideid = guideid;
    }

    public Integer getGuidestate() {
        return guidestate;
    }

    public void setGuidestate(Integer guidestate) {
        this.guidestate = guidestate;
    }

    public Object getAllsummary() {
        return allsummary;
    }

    public void setAllsummary(Object allsummary) {
        this.allsummary = allsummary;
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