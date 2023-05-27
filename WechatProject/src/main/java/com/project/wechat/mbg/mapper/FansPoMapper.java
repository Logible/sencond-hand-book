package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.FansPo;
import com.project.wechat.mbg.pojo.FansPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface FansPoMapper {
    long countByExample(FansPoExample example);

    int deleteByExample(FansPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FansPo record);

    int insertSelective(FansPo record);

    List<FansPo> selectByExample(FansPoExample example);

    FansPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FansPo record, @Param("example") FansPoExample example);

    int updateByExample(@Param("record") FansPo record, @Param("example") FansPoExample example);

    int updateByPrimaryKeySelective(FansPo record);

    int updateByPrimaryKey(FansPo record);
}