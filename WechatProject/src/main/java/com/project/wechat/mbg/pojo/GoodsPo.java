package com.project.wechat.mbg.pojo;

import com.project.wechat.dto.Region;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsPo {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Integer goods_id;

    @ApiModelProperty(value = "商品的价格")
    private Integer goods_price;

    @ApiModelProperty(value = "商品的描述")
    private String goods_introduce;

    @ApiModelProperty(value = "商品类型")
    private Integer type_id;

    @ApiModelProperty(value = "商品数量")
    private Integer goods_collection;

    @ApiModelProperty(value = "卖家的id")
    private Integer seller_id;

    @ApiModelProperty(value = "商品的名字")
    private String goods_name;

    @ApiModelProperty(value = "商品的图片")
    private String goods_picture;

    @ApiModelProperty(value = "商品成色")
    private Integer fineness;

    @ApiModelProperty(value = "商品笔记")
    private Integer note;

    @ApiModelProperty(value = "商品状态")
    private String good_status;

    @ApiModelProperty(value = "所属于的学校")
    private Integer school_id;

    @ApiModelProperty(value = "用户的名片信息")
    private String goods_contactInformation;

    //=================================非数据库字段============================
    @ApiModelProperty(value = "用户信息")
    private UserPo user;

    @ApiModelProperty(value = "图片数组")
    private String[] pics;

    @ApiModelProperty(value = "seller_id的映射")
    private Integer goods_upload_id;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public Integer getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Integer goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_introduce() {
        return goods_introduce;
    }

    public void setGoods_introduce(String goods_introduce) {
        this.goods_introduce = goods_introduce;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getGoods_collection() {
        return goods_collection;
    }

    public void setGoods_collection(Integer goods_collection) {
        this.goods_collection = goods_collection;
    }

    public Integer getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(Integer seller_id) {
        this.seller_id = seller_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_picture() {
        return goods_picture;
    }

    public void setGoods_picture(String goods_picture) {
        this.goods_picture = goods_picture;
    }

    public Integer getFineness() {
        return fineness;
    }

    public void setFineness(Integer fineness) {
        this.fineness = fineness;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public String getGood_status() {
        return good_status;
    }

    public void setGood_status(String good_status) {
        this.good_status = good_status;
    }

    public Integer getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Integer school_id) {
        this.school_id = school_id;
    }

    public String getGoods_contactInformation() {
        return goods_contactInformation;
    }

    public void setGoods_contactInformation(String goods_contactInformation) {
        this.goods_contactInformation = goods_contactInformation;
    }

    public UserPo getUser() {
        return user;
    }

    public void setUser(UserPo user) {
        this.user = user;
    }

    public String[] getPics() {
        return pics;
    }

    public void setPics(String[] pics) {
        this.pics = pics;
    }

    public Integer getGoods_upload_id() {
        return goods_upload_id;
    }

    public void setGoods_upload_id(Integer goods_upload_id) {
        this.goods_upload_id = goods_upload_id;
    }
}