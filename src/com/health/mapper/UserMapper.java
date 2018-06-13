package com.health.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.health.model.User;

@Repository
public interface UserMapper {
	/*
	 * 查询所有用户信息
	 */
	public List<User> findAllUser();

}
