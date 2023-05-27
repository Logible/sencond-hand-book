package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer scId;

    @ApiModelProperty(value = "学校名称")
    private String scName;

    @ApiModelProperty(value = "类型，校区还是学校")
    private String type;

    @ApiModelProperty(value = "是否为0（根结点），0的话是校区，这一字段便于构成学校和校区的树形结构")
    private String belong;

}