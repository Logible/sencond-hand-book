package com.project.wechat.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Properties {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("进行搜索操作的用户id")
    private Integer user_id;
    @ApiModelProperty("查找的内容")
    private String searchText;
    @ApiModelProperty("是否查找自己学校")
    private String isMySchool;
    @ApiModelProperty("商品成色")
    private String fineness;
    @ApiModelProperty("标记商品笔记的字段")
    private String note;
    @ApiModelProperty("学校id")
    private Integer schoolId;
    @ApiModelProperty("排序顺序")
    private String order;

}
