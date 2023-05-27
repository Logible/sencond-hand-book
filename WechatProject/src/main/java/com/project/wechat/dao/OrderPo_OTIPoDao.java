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
public interface OrderPo_OTIPoDao {
    //买家
    public final String BUYER = "0";
    //卖家
    public final String SELLER = "1";
    //已完成
    public final String FINISH = "1";
    //未完成
    public final String UN_FINISH = "0";

    /*
    * 获取订单表
    * */
    public OrderPo_OTI getDataFromOrderList(@Param("orderId") Integer orderId);

    /*
    * 删除订单表
    * */
    public Integer deleteOrderById(@Param("orderId") Integer orderId);

    /*
    * 修改订单表
    * */
    public Integer updateOrder(OrderPo_OTI orderPo_oti);
    /*
    * 创建订单表
    * */
    public Integer createOrder(OrderPo_OTI orderPo_oti);

    /*
    * 更改订单中用户状态
    * */
    public Integer updateOrderListUserStatus(@Param("orderId") Integer orderId,
                                              @Param("role") String role);

    /*
    * 更改订单状态
    * */
    //订单完成
    public Integer updateOrderListStatus(@Param("orderId") Integer orderId);
    //同意订单
    public Integer agreeOrder(@Param("orderId") Integer orderId);
    //拒绝订单
    public Integer refuseOrder(@Param("orderId") Integer orderId);

    /*
    * 获取我待取，我代发的订单
    * */
    public List<OrderPo_OTI> getOrderList(@Param("userId") Integer userId,
                                          @Param("role") String role,
                                          @Param("status") String status);

    /*
    * 统计正在交易中的订单，作为买家
    * */
    public Integer getUnreadMineAsBuyer(@Param("userId") String userId);

    /*
     * 统计正在交易中的订单，作为卖家
     * */
    public Integer getUnreadMineAsSeller(@Param("userId") String userId);

    /*
    * 根据orderId返回返回order信息
    * */
    public OrderPo_OTI getOrder(@Param("orderId") Integer orderId);

    /*
    * 得到订单的数目
    * */
    public Integer getOrderListCnt(@Param("userId")Integer userId,
                                       @Param("role")String role,
                                       @Param("status") String status);

    /*
    * 取消订单,之江status设置为-1
    * */
    public Integer cancelOrder(@Param("orderId") Integer orderId);

}
