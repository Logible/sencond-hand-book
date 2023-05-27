package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.HistorySearchPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HistorySearchPoDao {
    List<HistorySearchPo> getHistorySearchByUserId(@Param("userId") Integer userId, @Param("cnt") String cnt);
    Integer getUserHistoryCount(Integer userId);
    /*
    *插入历史搜索
    **/
    Integer insertHS(HistorySearchPo historySearchPo);

}
