package com.health.entity;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
/**
 * 
 * @author JSY修改
 * @date 6月21日
 */
@Component
public class Personinfo {
	//id
    private Integer personinfoid;
    //身份证
    private Object identity;
    //名字
    private Object name;
    //年龄
    private Integer age;
    //性别
    private Object sex;
    //电话号码
    private Object telephone;
    //企业账号
    private Object account;
    //条形码
    private BigDecimal barcode;

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
}