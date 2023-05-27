package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FansPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "用户的id")
    private Integer userId;

    @ApiModelProperty(value = "用户粉丝的id")
    private Integer fansId;

}