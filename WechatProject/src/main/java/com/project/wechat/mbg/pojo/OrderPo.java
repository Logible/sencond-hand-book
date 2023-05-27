package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPo {
    private static final long serialVersionUID = 1L;
    private Integer order_id;

    @ApiModelProperty(value = "商品的id")
    private Integer goods_id;

    @ApiModelProperty(value = "日期")
    private Date date;

    @ApiModelProperty(value = "订单的交易ai状态")
    private Integer status;

    @ApiModelProperty(value = "买家的id")
    private Integer user_id;

    @ApiModelProperty(value = "卖家的id")
    private Integer seller_id;

}