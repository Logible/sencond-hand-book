package com.project.wechat.mbg.mapper;

import com.project.wechat.mbg.pojo.HistorySearchPo;
import com.project.wechat.mbg.pojo.HistorySearchPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistorySearchPoMapper {
    long countByExample(HistorySearchPoExample example);

    int deleteByExample(HistorySearchPoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HistorySearchPo record);

    int insertSelective(HistorySearchPo record);

    List<HistorySearchPo> selectByExample(HistorySearchPoExample example);

    HistorySearchPo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HistorySearchPo record, @Param("example") HistorySearchPoExample example);

    int updateByExample(@Param("record") HistorySearchPo record, @Param("example") HistorySearchPoExample example);

    int updateByPrimaryKeySelective(HistorySearchPo record);

    int updateByPrimaryKey(HistorySearchPo record);
}