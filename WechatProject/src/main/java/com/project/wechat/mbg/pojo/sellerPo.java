package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class sellerPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "卖家的id")
    private Integer sellerId;

    @ApiModelProperty(value = "卖家对应的用户id")
    private Integer userId;

    @ApiModelProperty(value = "卖家卖过的产品数")
    private Integer sellerCount;
}