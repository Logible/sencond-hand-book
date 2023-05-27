package com.project.wechat.service;

import com.project.wechat.mbg.pojo.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
* 1表示已经完成
* 0表示未完成
* 0 buy-id = userId 表示待取
* 0 seller-id = userId 表示待取
* 1 buy-id = userId = 已经买到
* TODO Dao写一个公共方法通过标识符号，标记上面四种情况
* */
public interface GoodsService {

    //得到历史发布商品数据
    public List<GoodsPo> getIRelease(Integer userId);

    //得到我收藏的数据
    public List<GoodsPo> getFavorites(Integer userId);

    //获取所有书籍分类
    public List<GoodTypePo> getAllGoodsType();

    //TODO
    //获取推荐商品
    public List<GoodsPo> getPromoteGoods();

    //发布新商品
    public Integer releaseNewGood(GoodsPo newGood);

    //将商品添加进收藏架
    public boolean addToFavorites(FavouritesPo favoriteGood);

    //取消收藏
    public boolean cancleFavourities(FavouritesPo favouritesPo);

    //更新订单表
    public boolean updateOrder(Integer orderId,Integer userId,Integer sellerId)throws Exception;

    //返回所有商品信息
    public List<GoodsPo> selectAllGoods(String schoolName,Integer userId);

    //更新商品信息
    public boolean updateGoods(GoodsPo goodsPo);

    //删除商品
    public boolean deleteGoods(Integer goodsId);

    //根据Id得到商品和用户的详细信息
    public GoodsPo getGoodsAndUser(Integer userId);

    //修改订单中买家交易状态
    public boolean updateOrderListBuyerStatus(Integer orderId);
    //修改订单中卖家交易状态
    public boolean updateOrderListSellerStatus(Integer orderId);

    //得到我待发的
    public List<OrderPo_OTI> getBeforeRelease(Integer userId);

    //得到我待取的
    public List<OrderPo_OTI> getBeforeTake(Integer userId);

    //得到我卖出的
    public List<OrderPo_OTI> getHaveSell(Integer userId);

    //得到我买到的
    public List<OrderPo_OTI> getHaveBuy(Integer useId);

    //得到我待发的订单数目
    public Integer getBeforeReleaseCnt(Integer userId);
    //得到我待取的订单数目
    public Integer getBeforeTakeCnt(Integer userId);
    //得到我卖出的订单数目
    public  Integer getHaveSellCnt(Integer userId);
    //得到我买到的
    public Integer getHaveBuyCnt(Integer useId);

    //统计正在交易中的订单，分买家和卖家
    public Integer getUnreadMine(String userId);

    //得到目录集合
    public List<CategoryPo> getCategory();

    //生成订单表
    public Integer createOrder(OrderPo_OTI orderPo_oti);

    //删除订单缓存表
    public boolean deleteOrderBuff(Integer  orderBuffId);

    //生成正式订单表
    public boolean toBeFormalOrder(OrderBuffPo orderBuffPo);

    //    * 根据orderId返回返回order信息
    public OrderPo_OTI getOrder(Integer orderId);

    //同意订单
    public boolean agreeOrder(Integer orderId, Integer goodsId);

    //拒绝订单
    public boolean refuseOrder(Integer orderId,Integer goodsId);

    //更新订单缓冲表
    public boolean  updateOrderBuff(OrderBuffPo orderBuffPo);

    //根据TypeName获得TYpeId
    public Integer getTypeIdByTypeName(String typeName);


    /*
     * 根据UserId获取SchoolId
     * */
    public  Integer getSchoolIdByUserId(Integer userId);

    /*
    * 将goods的json转换为Goods对象
    * */
    public GoodsPo StringToGoodsPo(String goodsPoStr);

    /*
    * 将Favourite的json字符串转换为Favourite对象
    * */
    public FavouritesPo StringToFavouritesPo(String Favourites);

    /*
    * j将订单表的json串转换为对象
    * */
    public OrderPo_OTI StringToOrderPo_OTI(String orderStr);

    /*
    * 将订单缓冲表的json转换为对象
    * */
    public OrderBuffPo StringToOrderBuff(String orderBuff);

    /*
    * 将订单表的json转换成对象
    * */
    public OrderPo_OTI StringToOrder(String orderStr);

    /*
    * 根据商品Id降价
    * */
    public boolean changeGoodsPrice(Integer goodsId,Integer goodsPrice);

    //删除订单表
    public boolean deleteOrder(Integer orderId);
    /*
     * 修改订单表
     * */
    public Integer updateOrder(OrderPo_OTI orderPo_oti);

    /*
    * 得到我发布的商品数目
    * */
    public Integer getIReleaseCnt(Integer userId);

    /*
    * 得到所有商品消息
    * */
    public List<GoodsPo> selectAllGoods();

    //取消订单
    public boolean cancelOrder(Integer orderId);

}
