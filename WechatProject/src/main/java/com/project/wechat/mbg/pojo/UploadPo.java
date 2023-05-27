package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UploadPo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Integer uploadId;

    @ApiModelProperty(value = "卖家的id")
    private Integer sellerId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "商品id")
    private Integer goodsId;

    @ApiModelProperty(value = "上传时间")
    private Date date;

    @ApiModelProperty(value = "判定上传状态，由管理员审核")
    private Integer status;

}