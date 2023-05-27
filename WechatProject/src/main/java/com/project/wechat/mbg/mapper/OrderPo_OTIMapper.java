package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.OrderPo_OTI;
import com.project.wechat.mbg.pojo.OrderPo_OTIExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderPo_OTIMapper {
    long countByExample(OrderPo_OTIExample example);

    int deleteByExample(OrderPo_OTIExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(OrderPo_OTI record);

    int insertSelective(OrderPo_OTI record);

    List<OrderPo_OTI> selectByExample(OrderPo_OTIExample example);

    OrderPo_OTI selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") OrderPo_OTI record, @Param("example") OrderPo_OTIExample example);

    int updateByExample(@Param("record") OrderPo_OTI record, @Param("example") OrderPo_OTIExample example);

    int updateByPrimaryKeySelective(OrderPo_OTI record);

    int updateByPrimaryKey(OrderPo_OTI record);
}