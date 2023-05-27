package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.HistoryBrowsing;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HistoryBrowsingDao {
    /*
    * 返回历史浏览字段内容
    * */
    public List<HistoryBrowsing> getHistoryBrowsing(@Param("userId") String userId);

    /*
    * 返回历史浏览数
    * */
    public Integer getHistoryBrowsingCnt(@Param("userId") Integer userId);

    /*
    * 插入历史浏览
    * */
    public Integer insertHB(HistoryBrowsing historyBrowsing);

    /*
    * 删除全部历史浏览
    * */
    public Integer deleteAllHB(@Param("userId") Integer userId);
}
