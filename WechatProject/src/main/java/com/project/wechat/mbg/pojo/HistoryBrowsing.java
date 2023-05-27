package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryBrowsing {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer user_id;

    private Integer goods_id;

    private Long date;

    /*非数据库字段信息*/
    private GoodsPo goodsInfo;
}