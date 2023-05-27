package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.OrderBuffPo;
import com.project.wechat.mbg.pojo.OrderBuffPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderBuffPoMapper {
    long countByExample(OrderBuffPoExample example);

    int deleteByExample(OrderBuffPoExample example);

    int deleteByPrimaryKey(Integer orderbId);

    int insert(OrderBuffPo record);

    int insertSelective(OrderBuffPo record);

    List<OrderBuffPo> selectByExample(OrderBuffPoExample example);

    OrderBuffPo selectByPrimaryKey(Integer orderbId);

    int updateByExampleSelective(@Param("record") OrderBuffPo record, @Param("example") OrderBuffPoExample example);

    int updateByExample(@Param("record") OrderBuffPo record, @Param("example") OrderBuffPoExample example);

    int updateByPrimaryKeySelective(OrderBuffPo record);

    int updateByPrimaryKey(OrderBuffPo record);
}