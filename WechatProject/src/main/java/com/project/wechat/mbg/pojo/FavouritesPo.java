package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouritesPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "收藏者的id")
    private Integer user_id;

    @ApiModelProperty(value = "收藏者收藏的货品ID")
    private Integer goods_id;

}