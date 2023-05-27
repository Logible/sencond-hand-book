package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.RegionPo;
import com.project.wechat.mbg.pojo.RegionPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface RegionPoMapper {
    long countByExample(RegionPoExample example);

    int deleteByExample(RegionPoExample example);

    int deleteByPrimaryKey(Integer scId);

    int insert(RegionPo record);

    int insertSelective(RegionPo record);

    List<RegionPo> selectByExample(RegionPoExample example);

    RegionPo selectByPrimaryKey(Integer scId);

    int updateByExampleSelective(@Param("record") RegionPo record, @Param("example") RegionPoExample example);

    int updateByExample(@Param("record") RegionPo record, @Param("example") RegionPoExample example);

    int updateByPrimaryKeySelective(RegionPo record);

    int updateByPrimaryKey(RegionPo record);
}