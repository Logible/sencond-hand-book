package com.project.wechat.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ThumbPoDao {
    //记录点赞用户
    public Integer recordThumbUser(@Param("goodsId") Integer goodsId, @Param("userId") Integer userId);
    //删除用户点赞记录
    public Integer deleteThumbRecord(@Param("goodsId") Integer goodsId, @Param("userId") Integer userId);
    //增加用户点赞数
    public Integer addThumb(@Param("userId")Integer userId);
    //减少用户点赞数
    public Integer reduceThumb(@Param("userId")Integer userId);
    //判断是否为某用户的点赞商品
    public Integer isThumbGoods(@Param("userId") Integer userId,@Param("goodsId") Integer goodsId);
    //检查是否已经点过赞
    public Integer checkThumbExist(@Param("goodsId") Integer goodsId, @Param("userId") Integer userId);
}
