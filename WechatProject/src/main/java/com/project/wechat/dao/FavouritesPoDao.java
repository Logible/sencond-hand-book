package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.FavouritesPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FavouritesPoDao {
    //得到收藏夹的数据
    public List<FavouritesPo> getFavouritesFrom(Integer userId);

    //返回收藏夹总数
    public Integer getFavouritesCnt(Integer userId);

    //判断是否为收藏商品
    public Integer isFavourites(@Param("userId") Integer userId,@Param("goodsId") Integer goodsId);
}
