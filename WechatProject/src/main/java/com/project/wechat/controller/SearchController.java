package com.project.wechat.controller;

import com.project.wechat.dao.UtilsDao;
import com.project.wechat.dto.Properties;
import com.project.wechat.mbg.pojo.*;
import com.project.wechat.service.GoodsService;
import com.project.wechat.service.Impl.ExternalService;
import com.project.wechat.service.SearchService;
import com.project.wechat.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Api(tags = "SearchController",description = "商品数据查询")
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @Autowired
    private ExternalService externalService;

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UtilsDao utilsDao;

    //TODO 将数据返回给前端，然后让前端将数据转发到search那边，并返回搜索页面
    //获得最新的10条
    @ApiOperation("得到历史搜索对象名称")
    @RequestMapping("/getHistoryContent")
    public List<String> getHistorySearch(@RequestParam("userId") Integer userId){
        return searchService.getHistorySearchName(userId);
    }

    //TODO 直接跳转到对应界面
    @ApiOperation("跳转到搜索的页面")
    @RequestMapping("/toSearchPage")
    public String toSearchPage(){
        return null;
    }

    //TODO the same as above
    @ApiOperation("根据产品类型返回搜索产品")
    @RequestMapping("/searchByType")
    public List<GoodsPo> searchByType(@RequestParam("type") Integer typeId,
                                      @RequestParam("sortType") String sortType){
        List<GoodsPo> goodsPoList = searchService.searchByType(typeId,sortType);
        for (GoodsPo goodsPo : goodsPoList) {
            goodsPo.setGoods_upload_id(goodsPo.getSeller_id());
        }
        return goodsPoList;
    }

    /*
    * 实现isbn查询书本信息
    * */
    @GetMapping(value="/isbn")
    @ResponseBody
    public DataPo getBookInfoByIsbn(String isbn) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        //如果自己的isbn库有，则直接直接返回,没有再调用外部接口
        DataPo dataPo = searchService.searchBookByIsbn(isbn);
        if(dataPo != null){
            return dataPo;
        }

        String bookInfo =  externalService.getBookInfoByIsbn(isbn);
        dataPo = externalService.StringToDataPo(bookInfo);
        externalService.insertISBN(dataPo);

        return dataPo;
    }

    /*
    * 根据学校名查找学校
    * */
    @ApiOperation("根据学校名查找学校")
    @RequestMapping("/searchSchool")
    @ResponseBody
    public List<String> searchSchool(String schoolName){
        return  searchService.searchSchoolByName(schoolName);
    }

    /*
    * 返回商品名
    * */
    @ApiOperation("返回商品名")
    @RequestMapping("/getGoodsNameList")
    @ResponseBody
    public List<String> searchGoodsByName(String keyword,Integer userId){
        return searchService.searchGoodsByName(keyword,userId);
    }


    /*
    * 返回历史浏览字段内容
    * */
    @ApiOperation("返回历史浏览字段内容")
    @RequestMapping("/getHistoryBrowsing")
    @ResponseBody
    public List<HistoryBrowsing> getHistoryBrowsing(String userId){
        List<HistoryBrowsing> historyBrowsingList = searchService.getHistoryBrowsing(userId);
        for (HistoryBrowsing historyBrowsing : historyBrowsingList) {
            historyBrowsing.getGoodsInfo().setGoods_upload_id(historyBrowsing.getGoodsInfo().getSeller_id());
        }
        return historyBrowsingList;
    }

    /*
     * 根据特定条件搜索商品
     * 所有条件不允许为空
     * */
    @ApiOperation("根据特定条件搜索商品")
    @RequestMapping("/searchGoodsWith")
    @ResponseBody
    public List<GoodsPo> searchGoodsWith(String properties){
        Properties propertiesPo = searchService.StringToProperties(properties);
        propertiesPo.setSchoolId(utilsDao.getSchoolIdByUserId(propertiesPo.getUser_id()));

        if(propertiesPo == null){
            return goodsService.selectAllGoods(
                    userService.getSChoolNameBySchoolId(
                            userService.getUserByUserId(
                                    propertiesPo.getUser_id()).getSchool_id()),null);
        }

        List<GoodsPo> goodsPoList = searchService.searchGoodsWith(propertiesPo);

        return goodsPoList;
    }
}
