package com.health.biz;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.health.entity.Hotpack;

@Service
public interface GuidPackBiz {
	public ArrayList<Hotpack> queryHot();

}
