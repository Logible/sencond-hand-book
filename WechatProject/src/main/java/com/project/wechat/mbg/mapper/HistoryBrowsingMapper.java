package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.HistoryBrowsing;
import com.project.wechat.mbg.pojo.HistoryBrowsingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryBrowsingMapper {
    long countByExample(HistoryBrowsingExample example);

    int deleteByExample(HistoryBrowsingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistoryBrowsing record);

    int insertSelective(HistoryBrowsing record);

    List<HistoryBrowsing> selectByExample(HistoryBrowsingExample example);

    HistoryBrowsing selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistoryBrowsing record, @Param("example") HistoryBrowsingExample example);

    int updateByExample(@Param("record") HistoryBrowsing record, @Param("example") HistoryBrowsingExample example);

    int updateByPrimaryKeySelective(HistoryBrowsing record);

    int updateByPrimaryKey(HistoryBrowsing record);
}