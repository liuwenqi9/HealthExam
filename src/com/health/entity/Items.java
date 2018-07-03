package com.health.entity;

import org.springframework.stereotype.Component;

@Component
public class Items {
    private Integer itemid;

    private Object itemname;

    private Integer deptid;

    private Long cost;
    
    private Integer classify;
    
    private Object deptname;
    
    private boolean checked;

    public Integer getItemid() {
        return itemid;
    }

    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    public Object getItemname() {
        return itemname;
    }

    public void setItemname(Object itemname) {
        this.itemname = itemname;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

	public Object getDeptname() {
		return deptname;
	}

	public void setDeptname(Object deptname) {
		this.deptname = deptname;
	}

	public Integer getClassify() {
		return classify;
	}

	public void setClassify(Integer classify) {
		this.classify = classify;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}