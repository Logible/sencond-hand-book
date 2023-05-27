package com.project.wechat.controller;

import com.github.pagehelper.PageHelper;
import com.project.wechat.mbg.pojo.GoodsPo;
import com.project.wechat.mbg.pojo.SuPo;
import com.project.wechat.mbg.pojo.UserPo;
import com.project.wechat.service.GoodsService;
import com.project.wechat.service.SearchService;
import com.project.wechat.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Api(tags = "ManageController",description = "用户控制系统")
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SearchService searchService;

    @ApiOperation("跳转到登录界面")
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @ApiOperation("登录验证")
    @RequestMapping("/Login")
    public String Login(@RequestParam("username") String monitorId,
                        @RequestParam("password")String monitorPassword,
                        Model model,
                        HttpSession session){
        if (monitorId == null || monitorPassword  == null){
            model.addAttribute("msg","用户名或者密码不能为空");
            return "login";
        }

        SuPo suPo = userService.monitorIsExist(monitorId,monitorPassword);
        if(suPo != null){
            //设置存放事件为5min
            session.setMaxInactiveInterval(300);
            session.setAttribute("USER_SESSION",suPo);
            return "redirect:handle";
        }

        model.addAttribute("用户不存在,请查询输入");
        return "login";
    }

    /*
    * 跳转到控制页面
    * */
    @RequestMapping("/handle")
    public String toHandle(){
        return "handleoptimise";
    }


    @ApiOperation("得到所有用户数据数")
    @RequestMapping("/selectUserCounts")
    @ResponseBody
    public Integer selectUserCounts(){
        return userService.selectUserCounts();
    }

    @ApiOperation("得到所有用户数据")
    @RequestMapping("/selectAllUser")
    @ResponseBody
    public List<UserPo>  selectAllUser(){
        return userService.selectAllUser();
    }

    @ApiOperation("得到所有用户数据")
    @RequestMapping("/selectAllUserP")
    @ResponseBody
    public List<UserPo>  selectAllUserP(@RequestBody Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<UserPo> list = userService.selectAllUser();
        return list;
    }

    @ApiOperation("删除用户")
    @RequestMapping("/deleteUser")
    @ResponseBody
    public boolean deleteUser(@RequestBody Integer userId){
        return userService.deleteUser(userId);
    }

    @ApiOperation("添加用户")
    @RequestMapping("/addUser")
    @ResponseBody
    public boolean addUser(@RequestBody UserPo userPo){
        System.out.println(userPo);
        return userService.addUser(userPo);
    }

    @ApiOperation("更改用户信息")
    @RequestMapping("/updateUser")
    @ResponseBody
    public boolean updateUser(@RequestBody UserPo userPo){
        System.out.println(userPo);
        return userService.updateUser(userPo);
    }

    @ApiOperation("查询用户")
    @RequestMapping("/searchUser")
    @ResponseBody
    public UserPo searchUser(UserPo userPo){
        return userService.searchUser(userPo);
    }

    @ApiOperation("根据主键查询用户")
    @RequestMapping("/selectUserByPK")
    @ResponseBody
    public UserPo selectUserByPK(@RequestBody Integer userId){
        return userService.selectUserByPK(userId);
    }

    @ApiOperation("封禁用户")
    @RequestMapping("/banUser")
    @ResponseBody
    public boolean banUser(Integer userId){
        return userService.banUser(userId);
    }

    @ApiOperation("退出登录")
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:toLogin";
    }

    //============================商品管理部分============================
    @ApiOperation("返回所有")
    @RequestMapping("/selectAllGoods")
    @ResponseBody
    public List<GoodsPo> selectAllGoods(){
        return goodsService.selectAllGoods(null,null);
    }



    //TODO  写一个窗口 给管理者填写数据然后打包成对象进行修改
    @ApiOperation("增加商品")
    @RequestMapping("/addGoods")
    @ResponseBody
    public Integer addGoods(GoodsPo newGoods){
        return goodsService.releaseNewGood(newGoods);
    }

    //TODO 添加一个警告框缓冲一下，确认警告框后再进行修改
    @ApiOperation("修改商品信息")
    @RequestMapping("/updateGoods")
    @ResponseBody
    public boolean updateGoods(GoodsPo goodsPo){
        return goodsService.updateGoods(goodsPo);
    }

    //TODO 添加一个警告框缓冲一下，确认警告框后再进行删除
    @ApiOperation("删除商品")
    @RequestMapping("/deleteGood")
    @ResponseBody
    public boolean deleteGoods(Integer goodsId){
        return goodsService.deleteGoods(goodsId);
    }


}
