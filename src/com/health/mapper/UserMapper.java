package com.health.mapper;

import java.util.List;

import com.health.model.User;

public interface UserMapper {
	/*
	 * 查询所有用户信息
	 */
	public List<User> findAllUser();

}