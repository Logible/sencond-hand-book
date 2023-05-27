package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.sellerPo;
import com.project.wechat.mbg.pojo.sellerPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface sellerPoMapper {
    long countByExample(sellerPoExample example);

    int deleteByExample(sellerPoExample example);

    int deleteByPrimaryKey(Integer sellerId);

    int insert(sellerPo record);

    int insertSelective(sellerPo record);

    List<sellerPo> selectByExample(sellerPoExample example);

    sellerPo selectByPrimaryKey(Integer sellerId);

    int updateByExampleSelective(@Param("record") sellerPo record, @Param("example") sellerPoExample example);

    int updateByExample(@Param("record") sellerPo record, @Param("example") sellerPoExample example);

    int updateByPrimaryKeySelective(sellerPo record);

    int updateByPrimaryKey(sellerPo record);
}