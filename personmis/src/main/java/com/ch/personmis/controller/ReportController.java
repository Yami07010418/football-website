package com.ch.personmis.controller;

import com.ch.personmis.entity.Report;
import com.ch.personmis.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class ReportController {
    @Resource
    private ReportService reportService;
    @GetMapping("/getNewStaffReport")
    public Map<String, Object> getNewStaffReport(Report report){
       return reportService.getNewStaffReport(report);
    }
    @PostMapping("/selectNewStaffReportByCon")
    public Map<String, Object> selectNewStaffReportByCon(@RequestBody Report report){
        return reportService.getNewStaffReport(report);
    }
    @GetMapping("/getQuitStaffReport")
    public Map<String, Object> getQuitStaffReport(Report report){
        return reportService.getQuitStaffReport(report);
    }
    @PostMapping("/selectQuitStaffReportByCon")
    public Map<String, Object> selectQuitStaffReportByCon(@RequestBody Report report){
        return reportService.getQuitStaffReport(report);
    }
    @GetMapping("/getTransferReport")
    public Map<String, Object> getTransferReport(Report report){
        return reportService.getTransferReport(report);
    }
    @PostMapping("/selectTransferStaffReportByCon")
    public Map<String, Object> selectTransferStaffReportByCon(@RequestBody Report report){
        return reportService.getTransferReport(report);
    }
}
