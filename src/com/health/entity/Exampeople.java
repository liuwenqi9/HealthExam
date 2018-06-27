package com.health.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Exampeople {
    private Integer personinfoid;

    private Object identity;

    private Object name;

    private Integer age;

    private Object sex;

    private Object telephone;

    private Object account;

    private BigDecimal barcode;

    private Object guidetime;

    private Integer guideid;

    private Short checkstate;

    private Object allsummary;

    private Object packname;

    private BigDecimal packageprice;
    
    //额外添加
    private Integer guideidCard; //导捡次数
    
    private Integer totalprice; //单次体检总价格
    
    private Object totalPackages; //单次体检包含的套餐种类

    public Integer getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}

	public Object getTotalPackages() {
		return totalPackages;
	}

	public void setTotalPackages(Object totalPackages) {
		this.totalPackages = totalPackages;
	}

	public Integer getGuideidCard() {
		return guideidCard;
	}

	public void setGuideidCard(Integer guideidCard) {
		this.guideidCard = guideidCard;
	}

	public Integer getPersoninfoid() {
        return personinfoid;
    }

    public void setPersoninfoid(Integer personinfoid) {
        this.personinfoid = personinfoid;
    }

    public Object getIdentity() {
        return identity;
    }

    public void setIdentity(Object identity) {
        this.identity = identity;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public Object getTelephone() {
        return telephone;
    }

    public void setTelephone(Object telephone) {
        this.telephone = telephone;
    }

    public Object getAccount() {
        return account;
    }

    public void setAccount(Object account) {
        this.account = account;
    }

    public BigDecimal getBarcode() {
        return barcode;
    }

    public void setBarcode(BigDecimal barcode) {
        this.barcode = barcode;
    }

    public Object getGuidetime() {
        return guidetime;
    }

    public void setGuidetime(Object guidetime) {
        this.guidetime = guidetime;
    }

    public Integer getGuideid() {
        return guideid;
    }

    public void setGuideid(Integer guideid) {
        this.guideid = guideid;
    }

    public Short getCheckstate() {
        return checkstate;
    }

    public void setCheckstate(Short checkstate) {
        this.checkstate = checkstate;
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

    public BigDecimal getPackageprice() {
        return packageprice;
    }

    public void setPackageprice(BigDecimal packageprice) {
        this.packageprice = packageprice;
    }
}