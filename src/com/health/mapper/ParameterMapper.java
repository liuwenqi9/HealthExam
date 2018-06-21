package com.health.mapper;

import com.health.entity.Parameter;
import com.health.entity.ParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface ParameterMapper {
	
	List<Parameter> queryParameter();  //参数列表查询
	int  insertParameter(Parameter parameter);  //     参数增加
	int deleteParameter(String paramname);    //通过参数名删除参数
	
	int lengthId();
	
    int countByExample(ParameterExample example);

    int deleteByExample(ParameterExample example);

    int deleteByPrimaryKey(Integer parameterid);

    int insert(Parameter record);

    int insertSelective(Parameter record);

    List<Parameter> selectByExample(ParameterExample example);

    Parameter selectByPrimaryKey(Integer parameterid);

    int updateByExampleSelective(@Param("record") Parameter record, @Param("example") ParameterExample example);

    int updateByExample(@Param("record") Parameter record, @Param("example") ParameterExample example);

    int updateByPrimaryKeySelective(Parameter record);

    int updateByPrimaryKey(Parameter record);
}