package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.GoodsPo;
import com.project.wechat.mbg.pojo.OrderPo;
import com.project.wechat.mbg.pojo.OrderPo_OTI;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderPoDao {
    /*
    * 数据库中status = 0 代表订单未完成
    * status = 1 代表订单完成
    * */
    //TODO 通过一条公用方法返回四种不同情况的数据
    public static final int UN_FINISH = 0;
    public static final int FINISH = 1;
    public static final int BUYER = 1;
    public static final int SELLER = 0;
    //得到订单表的数据
    public List<OrderPo> getDataFromOrderList(@Param("userId") Integer userId,
                                              @Param("isFinished")Integer isFinished,
                                              @Param("isBuyer") Integer isBuyer);

}
