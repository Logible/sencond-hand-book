package com.project.wechat.controller;

import com.project.wechat.MyException.UnSynchronizationException;
import com.project.wechat.mbg.pojo.HistoryBrowsing;
import com.project.wechat.mbg.pojo.HistorySearchPo;
import com.project.wechat.mbg.pojo.UserPo;
import com.project.wechat.service.GoodsService;
import com.project.wechat.service.SearchService;
import com.project.wechat.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Api(tags = "UserController",description = "用户数据操作")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @ApiOperation("通过code得到OpenId")
    @RequestMapping("/getOpenId")
    @ResponseBody
    public String getOpenId(String code){
        return userService.getUserOpenId(code);
    }
    @ApiOperation("返回用户的点赞数")
    @RequestMapping("/getUserThumbs")
    @ResponseBody
    public Integer getUserThumbs(Integer userId) {
        return userService.getUserThumbs(userId);
    }


    @ApiOperation("判断是否为我的关注")
    @RequestMapping("/isMyAttention")
    @ResponseBody
    public boolean isMyAttention(Integer userId,Integer OppId){
        return userService.isMyAttention(userId,OppId);
    }


    @ApiOperation("返回历史浏览数")
    @RequestMapping("/getFavouritesCnt")
    @ResponseBody
    public Integer getFavouritesCnt(Integer userId) {
        return userService.getFavouritesCnt(userId);
    }


    @ApiOperation("返回历史浏览数")
    @RequestMapping("/getHistoryBrowsingCnt")
    @ResponseBody
    public Integer getHistoryBrowsingCnt(Integer userId) {
        return userService.getHistoryBrowsingCnt(userId);
    }

    @ApiOperation("返回关注总数")
    @RequestMapping("/getAttentionCount")
    public Integer getAttentionCounts(@RequestParam("userId") Integer userId) {
        return userService.getAttentionCount(userId);
    }

    @ApiOperation("返回粉丝总数")
    @RequestMapping("/getFansCount")
    public Integer getFansCount(@RequestParam("userId") Integer userId) {
        return userService.getFansCount(userId);
    }

    @ApiOperation("关注用户")
    @RequestMapping("/followAUser")
    public boolean followAUser(@RequestParam("userId") Integer userId,
                               @RequestParam("followId") Integer followId) throws Exception {
        return userService.followAUser(userId, followId);
    }

    //FIXME 前端能否读出用户数据
    @ApiOperation("取消关注用户")
    @RequestMapping("/cancelFollowUser")
    public boolean cancelFollowUser(@RequestParam("userId") Integer userId,
                                    @RequestParam("followId") Integer followId) throws UnSynchronizationException {
        return userService.cancelFollowUser(userId, followId);
    }

    @ApiOperation("根据openId查找用户")
    @RequestMapping("/selectUserByOpenId")
    @ResponseBody
    public UserPo selectUserByOpenId(String open_id) {
        return userService.selectUserByOpenId(open_id);
    }

    @ApiOperation("更新用户数据")
    @RequestMapping("/updateUser")
    @ResponseBody
    public boolean updateUser(String user) {
        UserPo userPo = userService.StringToUser(user);
        userPo.setSchool_id(userService.getSchoolIdBySchoolName(userPo.getUser_school()));
        return userService.updateUser(userPo);
    }

    @ApiOperation("添加用户")
    @RequestMapping("/addUser")
    @ResponseBody
    public boolean addUser(String user) {
        UserPo userPo = userService.StringToUser(user);
        setUserPo(userPo);
        return userService.addUser(userPo);
    }


    @ApiOperation("判断用户是否在线")
    @RequestMapping("/isOnline")
    @ResponseBody
    public boolean isOnline(Integer userId) {
        return userService.getUserStatus(userId);
    }

    @ApiOperation("将用户设置为在线")
    @RequestMapping("/setUserOnline")
    @ResponseBody
    public boolean setUserOnline(Integer userId) {
        return userService.setUserOnline(userId);
    }

    @ApiOperation("将用户设置为离线")
    @RequestMapping("/setUserNotOnline")
    @ResponseBody
    public boolean setUserNotOnline(Integer userId) {
        return userService.setUserNotOnline(userId);
    }

    @ApiOperation("点赞")
    @RequestMapping("/addThumb")
    @ResponseBody
    public boolean addThumb(Integer goodsId, Integer userId) {
        return userService.recordThumbUser(goodsId, userId);
    }

    @ApiOperation("取消点赞")
    @RequestMapping("/deleteThumbRecord")
    @ResponseBody
    public boolean deleteThumbRecord(Integer goodsId, Integer userId) {
        return userService.deleteThumbRecord(goodsId, userId);
    }

    @ApiOperation("通过userId得到user的数据")
    @RequestMapping("/getUserByUserId")
    @ResponseBody
    public UserPo getUserByUserId(Integer userId) {
        return userService.getUserByUserId(userId);
    }


    @ApiOperation("得到id为userid的粉丝的user对象")
    @RequestMapping("/getFansById")
    @ResponseBody
    public List<UserPo> getFansById(Integer userId) {
        return userService.getFansById(userId);
    }

    @ApiOperation("得到id为userid的粉丝的user对象")
    @RequestMapping("/getAttentionById")
    @ResponseBody
    public List<UserPo> getAttentionById(Integer userId) {
        return userService.getAttentionersById(userId);
    }

    @ApiOperation("判断是否为某用户的点赞商品")
    @RequestMapping("/isThumb")
    @ResponseBody
    public boolean isThumbGoods(Integer userId, Integer goodsId) {
        return userService.isThumbGoods(userId, goodsId);
    }

    @ApiOperation("判断是否为某用户的收藏商品")
    @RequestMapping("/isFavourites")
    @ResponseBody
    public boolean isFavourites(Integer userId, Integer goodsId) {
        return userService.isFavourites(userId, goodsId);
    }

    @ApiOperation("删除全部历史浏览")
    @RequestMapping("/deleteAllHB")
    @ResponseBody
    public boolean deleteAllHB(Integer userId) {
       return   userService.deleteAllHB(userId);
    }

    @ApiOperation("插入历史搜索")
    @RequestMapping("/insertHS")
    @ResponseBody
    public boolean insertHS(String historySearchPo) {
        return userService.insertHS(userService.StringToHS(historySearchPo));
    }

    @ApiOperation("插入历史浏览")
    @RequestMapping("/insertHB")
    @ResponseBody
    public boolean insertHB(String historyBrowsing) {
        return userService.insertHB(userService.StringToHB(historyBrowsing));
    }

    @ApiOperation("返回me页面的所有值")
    @RequestMapping("/getAllCnt")
    @ResponseBody
    public List<Integer> Mine(Integer userId) {
        List<Integer> Mine = new ArrayList<>();
        //1.收藏
        Mine.add(userService.getFavouritesCnt(userId));
        //2.历史浏览
        Mine.add(userService.getHistoryBrowsingCnt(userId));
        //3.关注
        Mine.add(userService.getAttentionCount(userId));
        //4.粉丝数字
        Mine.add(userService.getFansCount(userId));
        //5.我发布的
        Mine.add(goodsService.getIReleaseCnt(userId));
        //6.我卖出的
        Mine.add(goodsService.getHaveSellCnt(userId));
        //7.我买到的
        Mine.add(goodsService.getHaveBuyCnt(userId));
        //8.待取的书
        Mine.add(goodsService.getBeforeTakeCnt(userId));
        //9.待发的书
        Mine.add(goodsService.getBeforeReleaseCnt(userId));

        return Mine;
    }


    //设置用户信息
    private void setUserPo(UserPo userPo){
        userPo.setAvatar_url(userPo.getUser_avatarUrl());
        userPo.setGender(userPo.getUser_gender());
        userPo.setNick_name(userPo.getUser_nickname());
        userPo.setSchool_id(userService.getSchoolIdBySchoolName(userPo.getUser_school()));
    }
}
