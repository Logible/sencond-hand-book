package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.GoodsPo;
import com.project.wechat.mbg.pojo.GoodsPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface GoodsPoMapper {
    long countByExample(GoodsPoExample example);

    int deleteByExample(GoodsPoExample example);

    int deleteByPrimaryKey(Integer goodsId);

    int insert(GoodsPo record);

    int insertSelective(GoodsPo record);

    List<GoodsPo> selectByExample(GoodsPoExample example);

    GoodsPo selectByPrimaryKey(Integer goodsId);

    int updateByExampleSelective(@Param("record") GoodsPo record, @Param("example") GoodsPoExample example);

    int updateByExample(@Param("record") GoodsPo record, @Param("example") GoodsPoExample example);

    int updateByPrimaryKeySelective(GoodsPo record);

    int updateByPrimaryKey(GoodsPo record);
}