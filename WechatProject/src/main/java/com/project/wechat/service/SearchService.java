package com.project.wechat.service;

import com.project.wechat.dto.Properties;
import com.project.wechat.mbg.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchService {
    //得到历史搜索数据
    public List<HistorySearchPo> getHistorySearch(Integer userId);
    //跳转到搜索的页面
    public String toSearchPage();

    //根据产品类型返回搜索产品
    public List<GoodsPo> searchByType(Integer typeId,String sortType);
    //根据isbn查询书本信息
    public DataPo searchBookByIsbn(String Isbn);
    /*
     * 根据学校名查找学校
     * */
    public List<String> searchSchoolByName(String schoolName);

    /*
     * 根据商品名查询商品
     * */
    public List<String> searchGoodsByName(String keyword,Integer userId);

    /*
    * 得到历史搜索的名称
    * */
    public List<String> getHistorySearchName(Integer userId);

    /*
     * 返回历史浏览字段内容
     * */
    public List<HistoryBrowsing> getHistoryBrowsing(String userId);

    /*
    * 根据条件搜索商品
    * */
    public  List<GoodsPo> searchGoodsWith(Properties properties);

    /*
    * 将Propretitesjson串转换对象
    * */
    public Properties StringToProperties(String propertiesStr);


}
