package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("举报表的主键")
    private Integer id;
    @ApiModelProperty("举报的商品id")
    private Integer goods_id;
    @ApiModelProperty("举报的原因")
    private String description;
    @ApiModelProperty("举报人的Id")
    private Integer send_id;
    @ApiModelProperty("举报的时间")
    private long timestamp;
}
