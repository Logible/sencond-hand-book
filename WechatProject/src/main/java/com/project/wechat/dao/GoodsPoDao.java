package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.FavouritesPo;
import com.project.wechat.mbg.pojo.GoodsPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsPoDao {
    /*
    * 得到一个卖家发布的全部商品
    * */
    public List<GoodsPo> getReleaseFrom(@Param("userId") Integer userId);

    /*
    * 发布新产品
    * */
    public Integer releaseNewGood(GoodsPo newGood);

    /*
    * 添加进收藏夹
    * */
    public Integer addToFavorite(FavouritesPo favouritesPo);

    /*
    * 取消收藏
    * */
    public Integer cancelFavorite(FavouritesPo favouritesPo);

    /*
    * 订单交易成功后，更改订单表的交易状态
    * TODO 建立订单缓冲区,t_orderbuff,一定时间内未交易，则取消订单，并删除此订单
    * */
    public Integer updateOrderStatus(@Param("orderId") Integer orderId,
                                     @Param("userId") Integer userId,
                                     @Param("sellerId") Integer sellerId);

    /*
    * 增加seller卖的产品数
    * */
    public Integer addSellerCount(@Param("sellerId") Integer sellerId);

    /*
    * 返回所有商品信息
    * */
    public List<GoodsPo> selectAllGoods(@Param("schoolId") Integer schoolId,
                                        @Param("userId") Integer userId);

    /*
    * 更新商品信息
    * */
    public Integer updateGoods(GoodsPo goodsPo);

    /*
    * 删除商品信息
    * */
    public Integer deleteGoods(@Param("goodsId")Integer goodsId);

    /*
    *  更改商品状态
    * */
    //将商品状态设置已经交易
    public Integer updateGoodsStatus(@Param("goodsId")Integer goodsId);
    //将商品状态设置为未交易
    public Integer refuseGoodsStatus(@Param("goodsId")Integer goodsId);

    /*
     * 根据商品Id降价
     * */
    public Integer changeGoodsPrice(@Param("goodsId")Integer goodsId, @Param("goodsPrice")Integer goodsPrice);

    /*
    * 得到我发布的商品数目
    * */
    public Integer getIReleaseCnt(@Param("userId") Integer userId);

    /*
    * 收藏商品时使得对应商品的collection增加
    * */
    public Integer addGoodsCollection(@Param("goodsId") Integer goodsId);

    /*
     * 取消收藏商品时使得对应商品的collection减少
     * */
    public Integer reduceGoodsCollection(@Param("goodsId") Integer goodsId);

}
