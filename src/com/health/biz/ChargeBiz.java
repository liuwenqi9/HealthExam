package com.health.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.health.entity.Charge;
import com.health.entity.ChargeExample;
import com.health.entity.ChargeExample.Criteria;
import com.health.mapper.ChargeMapper;
import com.health.util.MyTimeUtil;

@Service
@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=false)
public class ChargeBiz {

	@Resource
	ChargeMapper chargeMapper;
	
	@Resource
	ChargeExample chargeExample;
	
	//获取全部订单
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Charge> getAllBill() {
		chargeExample.clear(); //清空静态缓存
		chargeExample.setOrderByClause("time ASC"); //对下单时间进行倒序排列
		List<Charge> list = chargeMapper.selectByExample(chargeExample);
		return list;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public Charge getOneBill(Integer chargeid) {
		chargeExample.clear(); //清空静态缓存
		Charge charge = chargeMapper.selectByPrimaryKey(chargeid);
		return charge;
	}
	
	public void updateBill(Charge record) {
		chargeExample.clear(); //清空静态缓存
		record.setTime(MyTimeUtil.getTimeNowTogether());
		chargeMapper.updateByPrimaryKeySelective(record);
	}
	
	//查询企业账户
	public List<Charge> searchRecoder(String account){
		chargeExample.clear(); //清空静态缓存
		Criteria criteria = chargeExample.createCriteria();
		criteria.andAccountLike("%" + account + "%");
		chargeExample.setOrderByClause("chargeid DESC");
		List<Charge> list = chargeMapper.selectByExample(chargeExample);
		return list;
	}
	
	//改变订单状态 --- 结算
	public int changeBill(Charge record) {
		chargeExample.clear(); //清空静态缓存
		record.setTime(MyTimeUtil.getTimeNowTogether());
		int result = chargeMapper.updateByPrimaryKeySelective(record);
		return result;
	}
}
