package com.project.wechat.mbg.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("图书图片地址")
    private String img;
    @ApiModelProperty("作者")
    private String author;
    @ApiModelProperty("isbn号")
    private String isbn;
    @ApiModelProperty("开本")
    private String format;
    @ApiModelProperty("版次")
    private String edition;
    @ApiModelProperty("装帧")
    private String binding;
    @ApiModelProperty("图书名称")
    private String title;
    @ApiModelProperty("")
    private String produce;
    @ApiModelProperty("内容简介")
    private String gist;
    @ApiModelProperty("胶版纸")
    private String paper;
    @ApiModelProperty("价格")
    private String price;
    @ApiModelProperty("出版商")
    private String publisher;
    @ApiModelProperty("页数")
    private String page;
    @ApiModelProperty("出版时间")
    private String pubdate;
}
