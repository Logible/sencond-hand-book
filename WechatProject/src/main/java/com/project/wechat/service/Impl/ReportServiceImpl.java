package com.project.wechat.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.project.wechat.dao.ReportPoDao;
import com.project.wechat.mbg.pojo.ReportPo;
import com.project.wechat.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportPoDao reportPoDao;

    //得到举报的信息
    @Override
    public List<ReportPo> getReportList() {
        return reportPoDao.getReportList();
    }

    //增加举报的信息
    @Override
    public Integer insertReport(ReportPo reportPo) {
        if(reportPoDao.insertReport(reportPo) > 0){
            return reportPo.getId();
        }
        return -1;
    }

    //删除举报的信息
    @Override
    public boolean deleteReport(Integer reportId) {
        return reportPoDao.deleteReport(reportId) > 0;
    }

    //修改举报的信息
    @Override
    public boolean updateReport(ReportPo reportPo) {
        return reportPoDao.updateReport(reportPo) > 0;
    }

    public ReportPo StringToReport(String reportStr){
        return JSONObject.parseObject(reportStr,new TypeReference<ReportPo>(){});
    }
}
