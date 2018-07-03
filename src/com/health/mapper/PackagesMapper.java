package com.health.mapper;

import com.health.entity.Packages;
import com.health.entity.PackagesExample;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PackagesMapper {
	
	ArrayList<Packages> getAllPackages(); //获取所有的套餐

	Packages getPackageById(String packageId);  //根据ID号获取相应的套餐
	
	int countByExample(PackagesExample example);

    int deleteByExample(PackagesExample example);

    int deleteByPrimaryKey(Integer packageid);

    int insert(Packages record);

    int insertSelective(Packages record);

    List<Packages> selectByExample(PackagesExample example);

    Packages selectByPrimaryKey(Integer packageid);

    int updateByExampleSelective(@Param("record") Packages record, @Param("example") PackagesExample example);

    int updateByExample(@Param("record") Packages record, @Param("example") PackagesExample example);

    int updateByPrimaryKeySelective(Packages record);

    int updateByPrimaryKey(Packages record);

	String getPriceByPackageId(String packageId); //根据套餐ID号来获取该套餐的价格
	
	List<Packages> selectPageList(@Param("sItemName") String sItemName);

	int selectPackidByPackname(String packname);


}