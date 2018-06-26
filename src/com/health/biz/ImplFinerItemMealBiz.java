package com.health.biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.health.entity.Dept;
import com.health.entity.DeptExample;
import com.health.entity.Detail;
import com.health.entity.DetailExample;
import com.health.entity.Items;
import com.health.entity.Parameter;
import com.health.mapper.DeptMapper;
import com.health.mapper.DetailMapper;
import com.health.mapper.ItemsMapper;
import com.health.mapper.PackitemMapper;

/*
 * 细项项目套餐业务层实现类
 * @author PYC
 * @date 6月19日
 */
@Service
@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=false)
public class ImplFinerItemMealBiz implements FinerItemMealBiz{
	
	@Resource
	DetailMapper detailMapper;
	@Resource
	ItemsMapper itemsMapper;
	@Resource
	PackitemMapper packitemMapper;
	@Resource
	DeptMapper deptMapper;
	@Resource 
	DeptExample deptExample;
	@Resource
	DetailExample detailExample;
	
	/*
	 * 细项分页查询
	 * param1: page 查询页
	 * param2: type 查询的表
	 * return: List<Object> 列表
	 */
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Detail> selectDetailPage(String sItemName){
		List<Detail> list = detailMapper.selectPageList(sItemName);
		return list;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public Detail selectById(int id){
		Detail detail = detailMapper.selectByPrimaryKey(id);
		return detail;
	}
	
	public int updateByDetail(Detail detail){
		return detailMapper.updateByPrimaryKey(detail);
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Parameter> selectAllParameter() {
		return detailMapper.selectAllParameter();
	}
	
	public int insertDetail(Detail detail){
		return detailMapper.insert(detail);
	}
	
	public int deleteDetailById(Integer detailid){
		return detailMapper.deleteByPrimaryKey(detailid);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Items> selectItemPage(String sItemName){
		List<Items> list = itemsMapper.selectPageList(sItemName);
		return list;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Dept> selectAllDept(){
		deptExample.clear();//清空Where条件
		deptExample.setOrderByClause("deptid DESC"); //对ID进行倒序排列
		List<Dept> list = deptMapper.selectByExample(deptExample);		
		return list;
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
	public List<Detail> selectDetailByItemId(Integer itemId){
		return detailMapper.selectByItemId(itemId);
	}
	
}