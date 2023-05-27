package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "学校名称")
    private String school_name;

    @ApiModelProperty(value = "学校标识符")
    private String school_code;

    @ApiModelProperty(value = "主管部门")
    private String manage_department;

    @ApiModelProperty(value = "所在地")
    private String location;

    @ApiModelProperty(value = "办学层次")
    private String school_layer;

    @ApiModelProperty(value = "备注（民办还是公办）")
    private String notes;

}