package com.health.biz;

import org.springframework.stereotype.Service;

import com.health.entity.Worker;
/*
 * 时间:2018.6.14
 * 登陆接口类
 * @author 毛聪
 */
@Service
public interface IntLoginBiz {
	
	public Worker loginAdmin(Worker worker);
	
	public int updatePwdWorker(Worker worker);

}
