package com.project.wechat.controller;

import com.project.wechat.mbg.pojo.*;
import com.project.wechat.service.GoodsService;
import com.project.wechat.service.Impl.ExternalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*
* TODO
*  订单完成后把goods信息删除？
* */
@Api(tags = "GoodsController" ,description = "商品数据操作")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ExternalService externalService;

    @ApiOperation("取消订单")
    @RequestMapping("/cancelOrder")
    public boolean cancelOrder(Integer orderId) {
        return goodsService.cancelOrder(orderId);
    }

    @ApiOperation("更新商品")
    @RequestMapping("/updateGoods")
    public boolean updateGoods(String goodsStr){
        GoodsPo goods = goodsService.StringToGoodsPo(goodsStr);
        goods.setSchool_id(goodsService.getSchoolIdByUserId(goods.getSeller_id()));
        return goodsService.updateGoods(goods);
    }

    @ApiOperation("根据id返回商品详细信息")
    @RequestMapping("/getGoodsAndUser")
    public GoodsPo getGoodsAndUser(Integer goodsId) {
        return goodsService.getGoodsAndUser(goodsId);
    }

    @ApiOperation("根据goodsId删除商品")
    @RequestMapping("/deleteGoodsById")
    public boolean deleteGoodsById(Integer goodsId) {
        return goodsService.deleteGoods(goodsId);
    }

    @ApiOperation("得到我发布的商品数据")
    @RequestMapping("/getIRelease")
    public List<GoodsPo> getIRealease(@RequestParam("userId") Integer userId) {
        return goodsService.getIRelease(userId);
    }

    @ApiOperation("得到我待发货的商品订单")
    /*/getOrderListOfSend*/
    @RequestMapping("/getOrderListOfUnSell")
    public List<OrderPo_OTI> getIBeforeRealease(@RequestParam("userId") Integer userId) {
        return goodsService.getBeforeRelease(userId);
    }

    @ApiOperation("得到我待取的商品订单")
    /*getOrderListOfTake*/
    @RequestMapping("/getOrderListOfUnTake")
    public List<OrderPo_OTI> getBeforeGet(@RequestParam("userId") Integer userId) {
        return goodsService.getBeforeTake(userId);
    }

    @ApiOperation("得到我买到的商品订单")
    /*getOrderOfBuy*/
    @RequestMapping("/getOrderListOfHaveBought")
    public List<OrderPo_OTI> getHaveBought(@RequestParam("userId") Integer userId) {
        return goodsService.getHaveBuy(userId);
    }

    @ApiOperation("得到我卖出的订单")
    /*getOrderOfSeller*/
    @RequestMapping("/getOrderListOfHaveSold")
    public List<OrderPo_OTI> getHaveSold(@RequestParam("userId") Integer userId) {
        return goodsService.getHaveSell(userId);
    }

    @ApiOperation("得到我收藏的数据")
    @RequestMapping("/getFavorites")
    public List<GoodsPo> getFavorites(@RequestParam("userId") Integer userId) {
        return goodsService.getFavorites(userId);
    }

    //TODO
    @ApiOperation("获取推荐商品")
    @RequestMapping("/getPromote")
    public List<GoodsPo> getPromoteGoods() {
        return null;
    }

    @ApiOperation("发布新商品")
    @RequestMapping("/release")
    public Integer releaseNewGood(String newGoods) {
        GoodsPo newGood = goodsService.StringToGoodsPo(newGoods);

        newGood.setSchool_id(goodsService.getSchoolIdByUserId(newGood.getSeller_id()));


        String str = "";
        for (String pic : newGood.getPics()) {
            str += pic + ",";
        }
        newGood.setGoods_picture(str.replaceAll("\"", ""));
        return goodsService.releaseNewGood(newGood);
    }

    @ApiOperation("将商品添加进收藏架")
    @RequestMapping("/addToFavorites")
    public boolean addToFavourities(String favoriteGood) {
        return goodsService.addToFavorites(goodsService.StringToFavouritesPo(favoriteGood));
    }

    @ApiOperation("取消收藏")
    @RequestMapping("/cancelFavorites")
    public boolean cancleFavourities(String favouritesPo) {
        return goodsService.cancleFavourities(goodsService.StringToFavouritesPo(favouritesPo));
    }

    @ApiOperation("更新订单状态")
    @RequestMapping("/updateOrder")
    public boolean updateOrder(Integer orderId, Integer userId, Integer sellerId) throws Exception {
        return goodsService.updateOrder(orderId, userId, sellerId);
    }

    @ApiOperation("更新订单买家用户状态")
    @RequestMapping("/updateOrderListBuyerStatus")
    public boolean updateOrderListBuyerStatus(Integer orderId) {
        return goodsService.updateOrderListBuyerStatus(orderId);
    }

    @ApiOperation("更新订单卖家用户状态")
    @RequestMapping("/updateOrderListSellerStatus")
    public boolean updateOrderListSellerStatus(Integer orderId) {
        return goodsService.updateOrderListSellerStatus(orderId);
    }

    @ApiOperation(".查询数据库中的未读消息2（统计正在交易的订单，即订单status = 0")
    @RequestMapping("/getUnreadMine")
    public Integer getUnreadMine(String userId) {
        return goodsService.getUnreadMine(userId);
    }

    @ApiOperation("得到目录集合以及得到某一目录的全部书籍分类")
    @RequestMapping("/getCategory")
    public List<CategoryPo> getCategory() {
        return goodsService.getCategory();
    }

    @ApiOperation("生成订单")
    @RequestMapping("/createOrder")
    public Integer createOrder(String orderPo_oti) {
        return goodsService.createOrder(goodsService.StringToOrderPo_OTI(orderPo_oti));
    }

/*    @ApiOperation("删除订单缓存表")
    @RequestMapping("/deleteOrderBuff")
    public boolean deleteOrderBuff(Integer orderBuffId) {
        return goodsService.deleteOrderBuff(orderBuffId);
    }*/

 /*   @ApiOperation("生成正式订订单表")
    @RequestMapping("/toBeFormalOrder")
    public boolean toBeFormalOrder(String orderBuffPo) {
        return goodsService.toBeFormalOrder(goodsService.StringToOrderBuff(orderBuffPo));
    }*/

    @ApiOperation("根据orderId返回返回order信息")
    @RequestMapping("/getOrder")
    public OrderPo_OTI getOrder(Integer orderId) {
        return goodsService.getOrder(orderId);
    }

    @ApiOperation("同意订单")
    @RequestMapping("/agreeOrder")
    public boolean agreeOrder(Integer orderId, Integer goodsId) {
        return goodsService.agreeOrder(orderId, goodsId);
    }

    @ApiOperation("拒绝订单")
    @RequestMapping("/refuseOrder")
    public boolean refuseOrder(Integer orderId,Integer goodsId) {
        return goodsService.refuseOrder(orderId,goodsId);
    }

/*    @ApiOperation("更新订单缓冲表")
    @RequestMapping("/updateOrderBuff")
    public boolean updateOrderBuff(String orderBuffPo) {
        return goodsService.updateOrderBuff(goodsService.StringToOrderBuff(orderBuffPo));
    }*/

    @ApiOperation("返回所有商品信息")
    @RequestMapping("/getALLGoods")
    public List<GoodsPo> getAllGoods(String schoolName,Integer userId){
        return goodsService.selectAllGoods(schoolName,userId);
    }

  /*  public List<GoodsPo> getAllGoods(){
        return goodsService.selectAllGoods();
    }*/

    @ApiOperation("改变商品价格")
    @RequestMapping("/changeGoodsPrice")
    public boolean changeGoodsPrice(Integer goodsId,Integer goodsPrice){
        return goodsService.changeGoodsPrice(goodsId,goodsPrice);
    }

    @ApiOperation("删除订单表")
    @RequestMapping("/deleteOrder")
    public boolean deleteOrder(Integer orderId){
        return goodsService.deleteOrder(orderId);
    }

    @ApiOperation("修改订单表")
    @RequestMapping("/changeOrder")
    public boolean changeOrder(String orderPo){
        return goodsService.updateOrder(goodsService.StringToOrderPo_OTI(orderPo)) > 0;

    }

    @ApiOperation("得到我待发的订单数目")
    @RequestMapping("/getBeforeReleaseCnt")
    public Integer getBeforeReleaseCnt(Integer userId){
        return goodsService.getBeforeReleaseCnt(userId);
    }
    @ApiOperation("得到我待取的订单数目")
    @RequestMapping("/getBeforeTakeCnt")
    public Integer getBeforeTakeCnt(Integer userId){
        return goodsService.getBeforeTakeCnt(userId);
    }
    @ApiOperation("得到我卖出的订单数目")
    @RequestMapping("/getHaveSellCnt")
    public Integer getHaveSellCnt(Integer userId){
        return goodsService.getHaveSellCnt(userId);
    }

    @ApiOperation("得到我买到的订单数目")
    @RequestMapping("/getHaveBuyCnt")
    public Integer getHaveBuyCnt(Integer useId){
        return goodsService.getHaveBuyCnt(useId);
    }

    @ApiOperation("得到我发布的商品数目")
    @RequestMapping("/getIReleaseCnt")
    public Integer getIReleaseCnt(Integer userId){
        return goodsService.getIReleaseCnt(userId);
    }

    @ApiOperation("way")
    @RequestMapping("/isAddBook")
    public boolean isAddBoob(){
        return true;
    }
}