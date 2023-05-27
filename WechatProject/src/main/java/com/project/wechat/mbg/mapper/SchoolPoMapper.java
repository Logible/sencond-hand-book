package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.SchoolPo;
import com.project.wechat.mbg.pojo.SchoolPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolPoMapper {
    long countByExample(SchoolPoExample example);

    int deleteByExample(SchoolPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SchoolPo record);

    int insertSelective(SchoolPo record);

    List<SchoolPo> selectByExample(SchoolPoExample example);

    SchoolPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SchoolPo record, @Param("example") SchoolPoExample example);

    int updateByExample(@Param("record") SchoolPo record, @Param("example") SchoolPoExample example);

    int updateByPrimaryKeySelective(SchoolPo record);

    int updateByPrimaryKey(SchoolPo record);
}