package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "value")
    private Integer value;
}
