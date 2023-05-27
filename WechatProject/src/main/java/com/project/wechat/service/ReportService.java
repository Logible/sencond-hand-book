package com.project.wechat.service;

import com.project.wechat.mbg.pojo.ReportPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReportService {
    //得到举报的信息
    public List<ReportPo> getReportList();
    //增加举报的信息
    public Integer insertReport(ReportPo reportPo);
    //删除举报的信息
    public boolean deleteReport(Integer reportId);
    //修改举报的信息
    public boolean updateReport(ReportPo reportPo);
    //将字符串改变为report对象
    public ReportPo StringToReport(String reportStr);
}
