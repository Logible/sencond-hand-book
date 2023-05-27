package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodTypePo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer type_id;
    @ApiModelProperty(value = "商品类型的名称")
    private String type_name;
    @ApiModelProperty("类型的图片")
    private String type_purl;
    @ApiModelProperty("所属的目录Id")
    private Integer category_id;
}