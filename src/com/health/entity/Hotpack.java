package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Hotpack {
    private String packname;
    private String total;
    
    public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getPackname() {
        return packname;
    }

    public void setPackname(String packname) {
        this.packname = packname;
    }
}