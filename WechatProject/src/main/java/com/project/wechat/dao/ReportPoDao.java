package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.ReportPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportPoDao {
    //得到举报的信息
    public List<ReportPo> getReportList();
    //增加举报的信息
    public Integer insertReport(ReportPo reportPo);
    //删除举报的信息
    public Integer deleteReport(@Param("reportId") Integer reportId);
    //修改举报的信息
    public Integer updateReport(ReportPo reportPo);
}
