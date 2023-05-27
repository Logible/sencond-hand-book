package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.GoodTypePo;
import com.project.wechat.mbg.pojo.GoodTypePoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GoodTypePoMapper {
    long countByExample(GoodTypePoExample example);

    int deleteByExample(GoodTypePoExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(GoodTypePo record);

    int insertSelective(GoodTypePo record);

    List<GoodTypePo> selectByExample(GoodTypePoExample example);

    GoodTypePo selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") GoodTypePo record, @Param("example") GoodTypePoExample example);

    int updateByExample(@Param("record") GoodTypePo record, @Param("example") GoodTypePoExample example);

    int updateByPrimaryKeySelective(GoodTypePo record);

    int updateByPrimaryKey(GoodTypePo record);
}