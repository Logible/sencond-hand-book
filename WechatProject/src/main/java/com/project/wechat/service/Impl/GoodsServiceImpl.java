package com.project.wechat.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.project.wechat.MyException.UnSynchronizationException;
import com.project.wechat.dao.*;
import com.project.wechat.mbg.pojo.*;
import com.project.wechat.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional(rollbackFor = UnSynchronizationException.class)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private OrderPo_OTIPoDao orderPo_otiPoDao;
    @Autowired
    private GoodsPoDao goodsPoDao;
    @Autowired
    private FavouritesPoDao favouritesPoDao;
    @Autowired
    private GoodsTypePoDao goodsTypePoDao;
    @Autowired
    private UtilsDao utilsDao;
    @Autowired
    private CategoryPoDao categoryPoDao;
    @Autowired
    private OrderBuffPoDao orderBuffPoDao;
    /*
    * 得到我发布的商品
    * */
    @Override
    public List<GoodsPo> getIRelease(Integer userId) {
        List<GoodsPo> goodsPoList = goodsPoDao.getReleaseFrom(userId);
        //缓存查询过的type，避免重复查询
        for (GoodsPo goodsPo : goodsPoList) {
            setGoodsInfo(goodsPo);
        }
        return goodsPoList;
    }

    /*
    * 得到收藏夹的数据
    * */
    @Override
    public List<GoodsPo> getFavorites(Integer userId) {
        List<FavouritesPo> favouritesPoList
                =  favouritesPoDao.getFavouritesFrom(userId);
        List<GoodsPo> goodsPoList  = new ArrayList<>();

        for (FavouritesPo favouritesPo : favouritesPoList) {
            GoodsPo goodsPo = utilsDao.getGoodsById(favouritesPo.getGoods_id());
            setGoodsInfo(goodsPo);
            goodsPoList.add(goodsPo);
        }
        return goodsPoList;
    }

    /*
    * 得到所有商品的类型
    * */
    @Override
    public List<GoodTypePo> getAllGoodsType() {
        return goodsTypePoDao.getAllGoodsType();
    }

    //TODO
    /*
    * 得到推荐商品
    * */
    @Override
    public List<GoodsPo> getPromoteGoods() {
        return null;
    }

    /*
    * 发布新商品
    * */
    @Override
    public Integer releaseNewGood(GoodsPo newGood) {
        if(goodsPoDao.releaseNewGood(newGood) > 0){
            return newGood.getGoods_id();
        }
        return -1;
    }

    /*
    * 添加进收藏夹
    * */
    @Override
    public boolean addToFavorites(FavouritesPo favoriteGood) {
        if(utilsDao.checkFavoriteIsExist(favoriteGood) == null){
            goodsPoDao.addGoodsCollection(favoriteGood.getGoods_id());
            return goodsPoDao.addToFavorite(favoriteGood) > 0;
        }
        return false;
    }

    /*
    * 取消收藏夹
    * */
    @Override
    public boolean cancleFavourities(FavouritesPo favouritesPo) {
        if(utilsDao.checkFavoriteIsExist(favouritesPo) != null){
            goodsPoDao.reduceGoodsCollection(favouritesPo.getGoods_id());
            return goodsPoDao.cancelFavorite(favouritesPo) > 0;
        }
        return false;
    }

    /*
    * 订单交易成功后，更改订单表的交易状态
    * */
    public boolean updateOrder(Integer orderId,Integer userId,Integer sellerId) throws Exception{
        //保证在订单一定存在
        if(goodsPoDao.updateOrderStatus(orderId,userId, sellerId) > 0){
            if (addSellerCount(sellerId)){
                return true;
            }else {
                //未同步更新则回滚
                throw new UnSynchronizationException("同步更新失败");
            }
        }
        return false;
    }

    /*
    * 返回所有商品信息
    * */
    @Override
    public List<GoodsPo> selectAllGoods(String schoolName,Integer userId) {
        List<GoodsPo> goodsPoList = goodsPoDao.selectAllGoods(utilsDao.getSchoolIdBySchoolName(schoolName),userId);
        for (GoodsPo goodsPo : goodsPoList) {
            setGoodsInfo(goodsPo);
        }
        return goodsPoList;
    }

    /*
    * 更新商品
    * */
    @Override
    public boolean updateGoods(GoodsPo goodsPo) {
        return goodsPoDao.updateGoods(goodsPo) > 0;
    }

    /*
    * 删除商品
    * */
    @Override
    public boolean deleteGoods(Integer goodsId) {
        return goodsPoDao.deleteGoods(goodsId) > 0;
    }

    /*
    * 得到用户和商品信息
    * */
    @Override
    public GoodsPo getGoodsAndUser(Integer goodsId) {
        GoodsPo goodsPo = utilsDao.getGoodsById(goodsId);
        setGoodsInfo(goodsPo);
        return goodsPo;
    }


    /*
    * 更新订单表中的买家状态
    * 如果更新后买家和卖家状态都已经完成, 则更新订单状态
    * */
    @Override
    public boolean updateOrderListBuyerStatus(Integer orderId) {
        Integer temp = orderPo_otiPoDao.updateOrderListUserStatus(orderId,OrderPo_OTIPoDao.BUYER);
//        OrderPo_OTI orderPo_oti = orderPo_otiPoDao.getDataFromOrderList(orderId);
//        if(temp > 0 && orderPo_oti.getSeller_status() == 1){
//            if(updateOrderListStatus(orderId) == true){
//                return true;
//            }
//        }else if(temp > 0){
//            return true;
//        }
        if(temp > 0){
            return true;
        }

        return false;
    }

    /*
    * 更新订单表中的卖家状态
    * 如果更新后买家和卖家状态都已经完成，
    * 则更新订单状态
    * */
    @Override
    public boolean updateOrderListSellerStatus(Integer orderId) {
        Integer temp = orderPo_otiPoDao.updateOrderListUserStatus(orderId,OrderPo_OTIPoDao.SELLER);
        OrderPo_OTI orderPo_oti = orderPo_otiPoDao.getDataFromOrderList(orderId);
        if(temp > 0 && orderPo_oti.getBuyer_status() == 1){
            if(updateOrderListStatus(orderId) == true){
                return true;
            }
        }else if(temp > 0){
            return true;
        }
        return false;
    }

    /*
    * 得到还没发送的订单
    * */
    @Override
    public List<OrderPo_OTI> getBeforeRelease(Integer userId) {
        List<OrderPo_OTI> orderPoOtis
                = orderPo_otiPoDao.getOrderList(userId,OrderPo_OTIPoDao.SELLER,OrderPo_OTIPoDao.UN_FINISH);
        for (OrderPo_OTI orderPoOti : orderPoOtis) {
            Integer chatId = orderPoOti.getChat_wid();
            setOPT(orderPoOti);
            OPT_setOppoUser(orderPoOti,chatId,OrderPo_OTIPoDao.BUYER);
            OPT_setGoodsInfo(orderPoOti,chatId);
        }
        return orderPoOtis;
    }

    /*
    * 得到还未取的订单
    * */
    @Override
    public List<OrderPo_OTI> getBeforeTake(Integer userId) {
        List<OrderPo_OTI> orderPoOtis
                = orderPo_otiPoDao.getOrderList(userId,OrderPo_OTIPoDao.BUYER,OrderPo_OTIPoDao.UN_FINISH);
        for (OrderPo_OTI orderPoOti : orderPoOtis) {
            Integer chatId = orderPoOti.getChat_wid();
            setOPT(orderPoOti);
            OPT_setOppoUser(orderPoOti,chatId,OrderPo_OTIPoDao.SELLER);
            OPT_setGoodsInfo(orderPoOti,chatId);
        }
        return orderPoOtis;
    }

    /*
    * 得到已经卖出的订单
    * */
    @Override
    public List<OrderPo_OTI> getHaveSell(Integer userId) {
        List<OrderPo_OTI> orderPoOtis
                = orderPo_otiPoDao.getOrderList(userId,OrderPo_OTIPoDao.SELLER,OrderPo_OTIPoDao.FINISH);

        for (OrderPo_OTI orderPoOti : orderPoOtis) {
            Integer chatId = orderPoOti.getChat_wid();
            setOPT(orderPoOti);
            OPT_setOppoUser(orderPoOti,chatId,OrderPo_OTIPoDao.BUYER);
            OPT_setGoodsInfo(orderPoOti,chatId);
        }
        return orderPoOtis;
    }
    /*
    * 得到已经购买的订单
    * */
    @Override
    public List<OrderPo_OTI> getHaveBuy(Integer userId) {
        List<OrderPo_OTI> orderPoOtis
                = orderPo_otiPoDao.getOrderList(userId,OrderPo_OTIPoDao.BUYER,OrderPo_OTIPoDao.FINISH);
        for (OrderPo_OTI orderPoOti : orderPoOtis) {
            Integer chatId = orderPoOti.getChat_wid();
            setOPT(orderPoOti);
            OPT_setOppoUser(orderPoOti,chatId,OrderPo_OTIPoDao.SELLER);
            OPT_setGoodsInfo(orderPoOti,chatId);
        }
        return orderPoOtis;
    }

    //得到我待发的订单数目
    @Override
    public Integer getBeforeReleaseCnt(Integer userId) {
        return orderPo_otiPoDao.getOrderListCnt(userId,OrderPo_OTIPoDao.SELLER,OrderPo_OTIPoDao.UN_FINISH);
    }

    //得到我待取的订单数目
    @Override
    public Integer getBeforeTakeCnt(Integer userId) {
        return orderPo_otiPoDao.getOrderListCnt(userId,OrderPo_OTIPoDao.BUYER,OrderPo_OTIPoDao.UN_FINISH);
    }

    //得到我卖出的订单数目
    @Override
    public Integer getHaveSellCnt(Integer userId) {
        return orderPo_otiPoDao.getOrderListCnt(userId,OrderPo_OTIPoDao.SELLER,OrderPo_OTIPoDao.FINISH);
    }

    //得到我买到的订单数目
    @Override
    public Integer getHaveBuyCnt(Integer useId) {
        return orderPo_otiPoDao.getOrderListCnt(useId,OrderPo_OTIPoDao.BUYER,OrderPo_OTIPoDao.FINISH);
    }



    /*
    * 统计正在交易中的订单，分买家和卖家
    * */
    @Override
    public Integer getUnreadMine(String userId) {
        return orderPo_otiPoDao.getUnreadMineAsBuyer(userId) +
                orderPo_otiPoDao.getUnreadMineAsSeller(userId);
    }

    /*
    * 得到目录集合以及得到某一目录的全部书籍分类
    * */
    @Override
    public List<CategoryPo> getCategory() {
        List<CategoryPo> categoryPoList
                = categoryPoDao.getCategory();
        for (CategoryPo categoryPo : categoryPoList) {
            categoryPo.setGoodTypePoList(
                    categoryPoDao.getGoodsTypeFrom(categoryPo.getCategory_id()));
        }
        return categoryPoList;
    }

    //生成订单表
    @Override
    public Integer createOrder(OrderPo_OTI orderPo_oti) {
        if(orderPo_otiPoDao.createOrder(orderPo_oti) > 0){
            return orderPo_oti.getOrder_id();
        }
        return  -1;
    }

    /*
    * 删除订单表
    * */

    //删除订单缓存表
    @Override
    public boolean deleteOrderBuff(Integer orderBuffId) {
        return orderBuffPoDao.deleteOrderBuff(orderBuffId) > 0;
    }

//    生成正式订订单表
    @Override
    public boolean toBeFormalOrder(OrderBuffPo orderBuffPo) {
        return orderBuffPoDao.toBeFormalOrder(orderBuffPo) > 0;
    }

    //得到订单表
    @Override
    public OrderPo_OTI getOrder(Integer orderId) {
        OrderPo_OTI orderPo_oti  = orderPo_otiPoDao.getOrder(orderId);
        setOPT(orderPo_oti);
        OPT_setGoodsInfo(orderPo_oti,orderPo_oti.getChat_wid());

        return orderPo_oti ;
    }


    //同意订单
    @Override
    public boolean agreeOrder(Integer orderId,Integer goodsId) {
        if(orderPo_otiPoDao.agreeOrder(orderId) > 0){
            if(goodsPoDao.updateGoodsStatus(goodsId) > 0){
                return true;
            }
        }

        return false;
    }


    //拒绝订单
    @Override
    public boolean refuseOrder(Integer orderId,Integer goodsId) {
        if(orderPo_otiPoDao.refuseOrder(orderId) > 0){
            if(goodsPoDao.refuseGoodsStatus(goodsId) > 0){
                return true;
            }
        }

        return false;
    }

    //更新订单缓冲表
    @Override
    public boolean updateOrderBuff(OrderBuffPo orderBuffPo) {
        //商家同意直接更新成新的订单
        if(orderBuffPo.getAgree_status() == 1){
            if (toBeFormalOrder(orderBuffPo) == true){
                return orderBuffPoDao.updateOrderBuff(orderBuffPo) > 0;
            }
        }
        return false;
    }

    //根据TypeName获得TYpeId
    @Override
    public Integer getTypeIdByTypeName(String typeName) {
        return utilsDao.getTypeIdByTypeName(typeName);
    }

    /*
     * 根据UserId获取SchoolId
     * */

    @Override
    public Integer getSchoolIdByUserId(Integer userId) {
        return utilsDao.getSchoolIdByUserId(userId);
    }

    /*
     * 将goods的json转换为Goods对象
     * */
    @Override
    public GoodsPo StringToGoodsPo(String goodsPoStr) {
        GoodsPo goodsPo = JSONObject.parseObject(goodsPoStr, new TypeReference<GoodsPo>(){});
        return goodsPo;
    }

    /*
     * 将Favourite的json字符串转换为Favourite对象
     * */
    @Override
    public FavouritesPo StringToFavouritesPo(String Favourites) {
        FavouritesPo favouritesPo =
                JSONObject.parseObject(Favourites,new TypeReference<FavouritesPo>(){});
        return favouritesPo;
    }

    /*
     * j将订单缓冲表的json串转换为对象
     * */
    @Override
    public OrderPo_OTI StringToOrderPo_OTI(String orderStr) {
        OrderPo_OTI orderPo_oti
                = JSONObject.parseObject(orderStr,new TypeReference<OrderPo_OTI>(){});
        return orderPo_oti;
    }

    /*
     * 将订单缓冲表的json转换为对象
     * */
    @Override
    public OrderBuffPo StringToOrderBuff(String orderBuff) {
        OrderBuffPo orderBuffPo
                = JSONObject.parseObject(orderBuff,new TypeReference<OrderBuffPo>(){});
        return orderBuffPo;
    }

    @Override
    public OrderPo_OTI StringToOrder(String orderStr) {
        OrderPo_OTI orderPo_oti
                = JSONObject.parseObject(orderStr,new TypeReference<OrderPo_OTI>(){});
        return orderPo_oti;
    }

    //更改订单价格
    @Override
    public boolean changeGoodsPrice(Integer goodsId, Integer goodsPrice) {
        return goodsPoDao.changeGoodsPrice(goodsId,goodsPrice) > 0;
    }

    //删除订单表
    @Override
    public boolean deleteOrder(Integer orderId) {
        return orderPo_otiPoDao.deleteOrderById(orderId) > 0;
    }

//    修改订单表
    @Override
    public Integer updateOrder(OrderPo_OTI orderPo_oti) {
        return orderPo_otiPoDao.updateOrder(orderPo_oti);
    }

    //得到我发布的商品数目
    @Override
    public Integer getIReleaseCnt(Integer userId) {
        return goodsPoDao.getIReleaseCnt(userId);
    }

    /*
    * 得到所有商品消息
    * */
    @Override
    public List<GoodsPo> selectAllGoods() {
        List<GoodsPo> goodsPoList = utilsDao.getAllGoods();
        for (GoodsPo goodsPo : goodsPoList) {
            setGoodsInfo(goodsPo);
        }
        return goodsPoList;
    }

    //取消订单
    @Override
    public boolean cancelOrder(Integer orderId) {
        if(orderPo_otiPoDao.cancelOrder(orderId) > 0){
            if(goodsPoDao.refuseGoodsStatus(utilsDao.getGoodsIdByOrderId(orderId)) > 0){
                return true;
            }
        }
        return false;
    }

    /*
    * 测试收藏表是否存在数据
    * */
    private boolean isExist(FavouritesPo favouritesPo){
        return utilsDao.checkFavoriteIsExist(favouritesPo) == null;
    }

    /*
     * 卖出商品后，卖家的商品数增加
     * //TODO 交易成功后执行此方法
     * */

    private boolean addSellerCount(Integer sellerId) {
        return goodsPoDao.addSellerCount(sellerId) > 0;
    }

    /*
    * 得到用户信息
    * */
    private UserPo getUserInfo(Integer userId){
        return utilsDao.getUserById(userId);
    }

    /*
    * 更新订单表状态
    * */
    private boolean updateOrderListStatus(Integer orderId){
        return orderPo_otiPoDao.updateOrderListStatus(orderId) > 0;
    }

    /*
    * 通过chatId得到userId的数据
    * */
    private UserPo getUserByIdThroughChat(Integer useId,String role ){
        return utilsDao.getUserByIdThroughChat(useId,role);
    }

    /*
     * 通过缓存拿到学校
     * */
    private void getSchoolByTemp(GoodsPo goodsPo,HashMap<Integer,String> schoolTemp,Integer schoolId){
        if(schoolTemp.containsKey(schoolId)){
            goodsPo.getUser().setUser_school(schoolTemp.get(schoolId));
        }else {
            String schoolName = utilsDao.getSchoolById(schoolId);
            goodsPo.getUser().setUser_school(schoolName);
            schoolTemp.put(schoolId,schoolName);
        }
    }
    /*
     * 通过缓存拿到书本类型
     * */
    private void getGoodsTypeByTemp(GoodsPo goodsPo,HashMap<Integer,String> typeTemp,Integer typeId){
        if(typeTemp.containsKey(typeId)){
        }else {
            String typeName = goodsTypePoDao.selectTypeNameByTypeId(typeId);
            typeTemp.put(typeId,typeName);
        }
    }

    //设置订单表的对方用户信息
    private void OPT_setOppoUser(OrderPo_OTI orderPo_oti,Integer chatId,String role){
        orderPo_oti.setOppositeInfo(utilsDao.getUserByIdThroughChat(chatId,role));
        orderPo_oti.getOppositeInfo().setUser_school(utilsDao.getSchoolById(orderPo_oti.getOppositeInfo().getSchool_id()));
        orderPo_oti.getOppositeInfo().setUser_gender(orderPo_oti.getOppositeInfo().getGender());
        orderPo_oti.getOppositeInfo().setUser_nickname(orderPo_oti.getOppositeInfo().getNick_name());
        orderPo_oti.getOppositeInfo().setUser_avatarUrl(orderPo_oti.getOppositeInfo().getAvatar_url());
    }

    //设置订单表的商品用户信息
    private void OPT_setGoodsInfo(OrderPo_OTI orderPo_oti,Integer chatId){
        orderPo_oti.setGoodsInfo(utilsDao.getGoodsByChatId(chatId));
        orderPo_oti.getGoodsInfo().setUser(utilsDao.getUserById(orderPo_oti.getGoodsInfo().getSeller_id()));
        orderPo_oti.getGoodsInfo().getUser().setUser_school(utilsDao.getSchoolById(orderPo_oti.getGoodsInfo().getUser().getSchool_id()));
        orderPo_oti.getGoodsInfo().setPics(orderPo_oti.getGoodsInfo().getGoods_picture().split(","));
        orderPo_oti.getGoodsInfo().getUser().setUser_gender(orderPo_oti.getGoodsInfo().getUser().getGender());
        orderPo_oti.getGoodsInfo().getUser().setUser_avatarUrl(orderPo_oti.getGoodsInfo().getUser().getAvatar_url());
        orderPo_oti.getGoodsInfo().getUser().setUser_nickname(orderPo_oti.getGoodsInfo().getUser().getNick_name());
        orderPo_oti.getGoodsInfo().setGoods_upload_id(orderPo_oti.getGoodsInfo().getSeller_id());
    }

    //设置订单表的信息
    public void setOPT(OrderPo_OTI orderPo_oti){
        orderPo_oti.setId(orderPo_oti.getOrder_id());
        orderPo_oti.setChat_id(orderPo_oti.getChat_wid());
    }

    //设置商品信息
    private void setGoodsInfo(GoodsPo goodsPo){
        goodsPo.setUser(utilsDao.getUserById(goodsPo.getSeller_id()));
        goodsPo.setGoods_upload_id(goodsPo.getSeller_id());
        goodsPo.setPics(goodsPo.getGoods_picture().split(","));

        goodsPo.getUser().setUser_school(utilsDao.getSchoolByUserId(goodsPo.getUser().getUser_id()));
        goodsPo.getUser().setUser_gender(goodsPo.getUser().getGender());
        goodsPo.getUser().setUser_avatarUrl(goodsPo.getUser().getAvatar_url());
        goodsPo.getUser().setUser_nickname(goodsPo.getUser().getNick_name());
    }

}
