package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.AttentionPo;
import com.project.wechat.mbg.pojo.AttentionPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AttentionPoMapper {
    long countByExample(AttentionPoExample example);

    int deleteByExample(AttentionPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttentionPo record);

    int insertSelective(AttentionPo record);

    List<AttentionPo> selectByExample(AttentionPoExample example);

    AttentionPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttentionPo record, @Param("example") AttentionPoExample example);

    int updateByExample(@Param("record") AttentionPo record, @Param("example") AttentionPoExample example);

    int updateByPrimaryKeySelective(AttentionPo record);

    int updateByPrimaryKey(AttentionPo record);
}