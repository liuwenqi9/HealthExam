package com.health.mapper;

import com.health.entity.Examreport;
import com.health.entity.ExamreportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamreportMapper {
    int countByExample(ExamreportExample example);

    int deleteByExample(ExamreportExample example);

    int insert(Examreport record);

    int insertSelective(Examreport record);

    List<Examreport> selectByExample(ExamreportExample example);
    
    //额外添加SQL语句 --- 获取项目列表 Jove
    List<Examreport> selectItemsByExample(ExamreportExample example);
    
    //额外添加SQL语句 --- 获取项目报告Jove
    List<Examreport> selectDetailByExample(ExamreportExample example);
    
    //额外添加SQL语句 --- 获取项目报告Jove
    List<Examreport> selectAllSummaryByExample(ExamreportExample example);

    int updateByExampleSelective(@Param("record") Examreport record, @Param("example") ExamreportExample example);

    int updateByExample(@Param("record") Examreport record, @Param("example") ExamreportExample example);
}