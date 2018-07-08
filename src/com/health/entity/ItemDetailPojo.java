package com.health.entity;

import java.util.ArrayList;
import java.util.List;

public class ItemDetailPojo {

	private List<Examreport> list;
	
	private Integer id;
	
	private Object itemName;

	public List<Examreport> getList() {
		return list;
	}

	public void setList(List<Examreport> list) {
		this.list = (ArrayList<Examreport>) list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Object getItemName() {
		return itemName;
	}

	public void setItemName(Object itemName) {
		this.itemName = itemName;
	}
	
	
}
