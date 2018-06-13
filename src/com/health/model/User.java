package com.health.model;
//本类为测试类
public class User {
	private int id;
	private int username;
	public User() {
		super();
	}
	public User(int id, int username) {
		super();
		this.id = id;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "["+id+":"+ username+ "]";
	}

}
