package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBuffPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "订单缓冲表的id")
    private Integer orderb_id;

    @ApiModelProperty(value = "订单生成时间")
    private Date date;

    @ApiModelProperty(value = "交易地点")
    private String location;

    @ApiModelProperty(value = "聊天窗口id")
    private Integer chat_wid;

    @ApiModelProperty(value = "订单是否被卖家确认")
    private Integer agree_status;

}