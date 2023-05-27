package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatsPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("时间截")
    private long timestamp;
    @ApiModelProperty("卖家id")
    private Integer send_id;
    @ApiModelProperty("聊天内容")
    private String content;
    @ApiModelProperty("聊天状态")
    private Integer status;
    @ApiModelProperty("聊天窗口id")
    private Integer chat_id;
    @ApiModelProperty("订单表的id")
    private Integer order_id;
    @ApiModelProperty("提醒")
    private String notice;

    //=======非数据库字段
    @ApiModelProperty("卖家id")
    private Integer senderId;
}