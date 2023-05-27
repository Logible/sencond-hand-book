package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.OrderPo;
import com.project.wechat.mbg.pojo.OrderPoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderPoMapper {
    long countByExample(OrderPoExample example);

    int deleteByExample(OrderPoExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderPo record);

    int insertSelective(OrderPo record);

    List<OrderPo> selectByExample(OrderPoExample example);

    OrderPo selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderPo record, @Param("example") OrderPoExample example);

    int updateByExample(@Param("record") OrderPo record, @Param("example") OrderPoExample example);

    int updateByPrimaryKeySelective(OrderPo record);

    int updateByPrimaryKey(OrderPo record);
}