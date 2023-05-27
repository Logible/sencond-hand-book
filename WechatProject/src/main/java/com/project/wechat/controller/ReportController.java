package com.project.wechat.controller;

import com.project.wechat.mbg.pojo.ReportPo;
import com.project.wechat.service.ReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @ApiOperation("得到举报的信息")
    @RequestMapping("/getReportList")
    public List<ReportPo> getReportList() {
        return reportService.getReportList();
    }

    @ApiOperation("增加举报的信息")
    @RequestMapping("/insertReport")
    //增加举报的信息
    public Integer insertReport(String reportstr) {
        return reportService.insertReport(reportService.StringToReport(reportstr));
    }

    @ApiOperation("删除举报的信息")
    @RequestMapping("/deleteReport")
    //删除举报的信息
    public boolean deleteReport(Integer reportId) {
        return reportService.deleteReport(reportId);
    }

    @ApiOperation("修改举报的信息")
    @RequestMapping("/updateReport")
    //修改举报的信息
    public boolean updateReport(String reportstr) {
        return reportService.updateReport(reportService.StringToReport(reportstr));
    }
}
