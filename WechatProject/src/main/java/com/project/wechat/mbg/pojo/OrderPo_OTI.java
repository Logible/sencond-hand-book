package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPo_OTI {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer order_id;

    @ApiModelProperty(value = "日期")
    private Long date;

    @ApiModelProperty(value = "卖家的交易ai状态")
    private Integer seller_status;

    @ApiModelProperty(value = "买家的交易状态 ")
    private Integer buyer_status;

    @ApiModelProperty(value = "交易地点")
    private String location;

    @ApiModelProperty(value = "聊天窗口id ")
    private Integer chat_wid;

    @ApiModelProperty(value = "订单的状态 ")
    private Integer status;

    @ApiModelProperty(value = "标记作者是否同意")
    private Integer agree_status;

    /*====非数据库字段====*/

    @ApiModelProperty("对方的数据")
    private UserPo oppositeInfo;
    @ApiModelProperty("商品信息")
    private GoodsPo goodsInfo;

    @ApiModelProperty("聊天窗口id的映射")
    private Integer chat_id;
    @ApiModelProperty("order_id的映射")
    private Integer id;




}