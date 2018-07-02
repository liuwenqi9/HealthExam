package com.health.biz;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.health.entity.Veworker;
@Service
public interface VeworkerMgBiz {
	public ArrayList<Veworker>queryWorkerList();

}
