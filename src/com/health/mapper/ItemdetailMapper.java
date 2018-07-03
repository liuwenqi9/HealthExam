package com.health.mapper;

import com.health.entity.Itemdetail;
import com.health.entity.ItemdetailExample;
import com.health.entity.Items;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemdetailMapper {
    int countByExample(ItemdetailExample example);

    int deleteByExample(ItemdetailExample example);

    int deleteByPrimaryKey(Integer itemdetailid);

    int insert(Itemdetail record);

    int insertSelective(Itemdetail record);

    List<Itemdetail> selectByExample(ItemdetailExample example);

    Itemdetail selectByPrimaryKey(Integer itemdetailid);

    int updateByExampleSelective(@Param("record") Itemdetail record, @Param("example") ItemdetailExample example);

    int updateByExample(@Param("record") Itemdetail record, @Param("example") ItemdetailExample example);

    int updateByPrimaryKeySelective(Itemdetail record);

    int updateByPrimaryKey(Itemdetail record);

	void deleteByItemid(Integer itemid);
}