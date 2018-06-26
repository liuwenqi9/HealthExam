package com.health.mapper;

import com.health.entity.Items;
import com.health.entity.ItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemsMapper {
    int countByExample(ItemsExample example);

    int deleteByExample(ItemsExample example);

    int deleteByPrimaryKey(Integer itemid);

    int insert(Items record);

    int insertSelective(Items record);

    List<Items> selectByExample(ItemsExample example);

    Items selectByPrimaryKey(Integer itemid);

    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    int updateByPrimaryKeySelective(Items record);

    int updateByPrimaryKey(Items record);

    List<Items> selectPageList(@Param("sItemName") String sItemName);
}