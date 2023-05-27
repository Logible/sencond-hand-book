package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("主键")
    private Integer category_id;
    @ApiModelProperty("目录名称")
    private String category_name;

    /*非数据库字段*/
    @ApiModelProperty("拥有的书籍类型")
    private List<GoodTypePo> goodTypePoList;
}
