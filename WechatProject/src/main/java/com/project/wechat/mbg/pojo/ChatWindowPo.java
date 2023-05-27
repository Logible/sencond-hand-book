package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatWindowPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "聊天窗口id")
    private Integer id;

    @ApiModelProperty(value = "用户的id")
    private Integer user_id;

    @ApiModelProperty(value = "卖家的id")
    private Integer seller_id;

    @ApiModelProperty(value = "货品id")
    private Integer goods_id;
}