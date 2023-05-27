package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.OrderBuffPo;
import com.project.wechat.mbg.pojo.OrderPo_OTI;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderBuffPoDao {
    //生成订单缓冲表
    public Integer createOrderBuff(OrderBuffPo orderBuffPo);

    //删除订单表
    public Integer deleteOrderBuff(@Param("orderBuffId") Integer orderBuffId);

    //生成正式订订单表
    public Integer toBeFormalOrder(OrderBuffPo orderBuffPo);

    //更新订单缓冲表
    public Integer updateOrderBuff(OrderBuffPo orderBuffPo);
}
