package com.project.wechat.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.project.wechat.dao.*;
import com.project.wechat.dto.BeforeRegion;
import com.project.wechat.dto.Properties;
import com.project.wechat.dto.Region;
import com.project.wechat.mbg.mapper.UserPoMapper;
import com.project.wechat.mbg.pojo.*;
import com.project.wechat.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class SearchServiceImpl implements SearchService {
    @Autowired
    private HistorySearchPoDao historySearchPoDao;
    @Autowired
    private UtilsDao utilsDao;
    @Autowired
    private DataPoDao dataPoDao;
    @Autowired
    private SchoolPoDao schoolPoDao;
    @Autowired
    private HistoryBrowsingDao historyBrowsingDao;

    /*
    * 得到某一用户的历史搜索数据
    * */
    @Override
    public List<HistorySearchPo> getHistorySearch(Integer userId) {
        return historySearchPoDao.getHistorySearchByUserId(userId, getUserHistoryCount(userId).toString());
    }

    /*
    * 跳转到查找页面
    * 需要前端提供接口
    * */
    //TODO
    @Override
    public String toSearchPage() {
        return null;
    }


    /*
    * 选定类型时返回
    * 数据
    * */
    @Override
    public List<GoodsPo> searchByType(Integer typeId,String sortType) {
        return sortType == null?
                utilsDao.getGoodsByType(typeId,null)
                :utilsDao.getGoodsByType(typeId,sortType);
    }


    /*
     *根据isbn查询书本信息
     * */
    @Override
    public DataPo searchBookByIsbn(String isbn) {
        return dataPoDao.checkIsbnIsExist(isbn);
    }

    /*
    * 查找学校名称
    * */
    @Override
    public List<String> searchSchoolByName(String schoolName) {
        List<SchoolPo> schoolPoList = schoolPoDao.searchSchoolByName(schoolName);
        List<String> schoolNameList = new ArrayList<>();

        for (SchoolPo schoolPo : schoolPoList) {
            schoolNameList.add(schoolPo.getSchool_name());
        }

        return schoolNameList;
    }

    /*
    * 根据商品名查询商品
    * */
    public List<String> searchGoodsByName(String keyword,Integer userId){
        List<GoodsPo> goodsPoList =  utilsDao.getSearchByName(keyword,null,userId);
        List<String> goodsNameList = new ArrayList<>();
        for (GoodsPo goodsPo : goodsPoList) {
            goodsNameList.add(goodsPo.getGoods_name());
        }
        return goodsNameList;
    }


    /*
    * 得到历史搜索的名称
    * */
    @Override
    public List<String> getHistorySearchName(Integer userId){

        List<HistorySearchPo> historySearchPoList
                = historySearchPoDao.getHistorySearchByUserId(userId, getUserHistoryCount(userId).toString());

        List<String> historySearchName = new ArrayList<>();
        for (HistorySearchPo historySearchPo : historySearchPoList) {
            historySearchName.add(historySearchPo.getSearch_info());
        }
        return historySearchName;
    }

    /*
     * 返回历史浏览字段内容
     * */
    @Override
    public List<HistoryBrowsing> getHistoryBrowsing(String userId) {
        List<HistoryBrowsing> historyBrowsingList
                = historyBrowsingDao.getHistoryBrowsing(userId);
        for (HistoryBrowsing historyBrowsing : historyBrowsingList) {
            setHistoryBrowsing(historyBrowsing);
        }

        return historyBrowsingList;
    }

    /*
    * 根据特定条件搜索商品
    * */
    @Override
    public List<GoodsPo> searchGoodsWith(Properties properties) {
        List<GoodsPo> goodsPoList = utilsDao.searchGoods(properties);
        //转换字段
        for (GoodsPo goodsPo : goodsPoList) {
            setGoodsPo(goodsPo);
        }

        return goodsPoList;
    }

    /*
     * 将Propretitesjson串转换对象
     * */
    @Override
    public Properties StringToProperties(String propertiesStr) {
        return JSONObject.parseObject(propertiesStr,new TypeReference<Properties>(){});
    }


    /*得到用户搜索总数*/
    private Integer getUserHistoryCount(Integer userId){
        return historySearchPoDao.getUserHistoryCount(userId);
    }

    /*设置历史浏览的数据*/
    private void setHistoryBrowsing(HistoryBrowsing historyBrowsing){
        historyBrowsing.setGoodsInfo(utilsDao.getGoodsById(historyBrowsing.getGoods_id()));
        historyBrowsing.getGoodsInfo().setUser(utilsDao.getUserById(historyBrowsing.getGoodsInfo().getSeller_id()));
        historyBrowsing.getGoodsInfo().setPics(historyBrowsing.getGoodsInfo().getGoods_picture().split(","));
        historyBrowsing.getGoodsInfo().getUser().setUser_nickname(historyBrowsing.getGoodsInfo().getUser().getNick_name());
        historyBrowsing.getGoodsInfo().getUser().setUser_gender(historyBrowsing.getGoodsInfo().getUser().getGender());
        historyBrowsing.getGoodsInfo().getUser().setUser_avatarUrl(historyBrowsing.getGoodsInfo().getUser().getAvatar_url());
        historyBrowsing.getGoodsInfo().getUser().setUser_school(utilsDao.getSchoolByUserId(historyBrowsing.getGoodsInfo().getSeller_id()));
    }

    /*设置GoodsPo的数据*/
    private void setGoodsPo(GoodsPo goodsPo){
        goodsPo.setUser(utilsDao.getUserById(goodsPo.getSeller_id()));
        goodsPo.setGoods_upload_id(goodsPo.getSeller_id());
        goodsPo.setPics(goodsPo.getGoods_picture().split(","));

        goodsPo.getUser().setUser_gender(goodsPo.getUser().getGender());
        goodsPo.getUser().setUser_nickname(goodsPo.getUser().getNick_name());
        goodsPo.getUser().setUser_avatarUrl(goodsPo.getUser().getAvatar_url());
        goodsPo.getUser().setUser_school(utilsDao.getSchoolById(goodsPo.getUser().getSchool_id()));
    }
}
