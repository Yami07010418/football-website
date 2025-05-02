package com.ch.personmis.service;

import com.ch.personmis.entity.Report;
import com.ch.personmis.repository.ReportRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportRepository reportRepository;
    @Override
    public Map<String, Object> getNewStaffReport(Report report) {
        Map<String, Object> map = new HashMap<String, Object>();
        report.setAct("byPage");
        List<Map<String, Object>> newStaffReports = reportRepository.reportSelectNew(report);
        map.put("newStaffReports", newStaffReports);
        report.setAct("byNoPage");
        map.put("total", reportRepository.reportSelectNew(report).size());
        return map;
    }

    @Override
    public Map<String, Object> getQuitStaffReport(Report report) {
        Map<String, Object> map = new HashMap<String, Object>();
        report.setAct("byPage");
        List<Map<String, Object>> newQuitReports = reportRepository.reportSelectQuit(report);
        map.put("newQuitReports", newQuitReports);
        report.setAct("byNoPage");
        map.put("total", reportRepository.reportSelectQuit(report).size());
        return map;
    }

    @Override
    public Map<String, Object> getTransferReport(Report report) {
        Map<String, Object> map = new HashMap<String, Object>();
        report.setAct("byPage");
        List<Map<String, Object>> newTransferReports = reportRepository.reportSelectTransfer(report);
        map.put("newTransferReports", newTransferReports);
        report.setAct("byNoPage");
        map.put("total", reportRepository.reportSelectTransfer(report).size());
        return map;
    }
}
