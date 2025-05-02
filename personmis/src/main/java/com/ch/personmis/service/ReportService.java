package com.ch.personmis.service;

import com.ch.personmis.entity.Report;

import java.util.Map;

public interface ReportService {
    Map<String, Object> getNewStaffReport(Report report);
    Map<String, Object> getQuitStaffReport(Report report);
    Map<String, Object> getTransferReport(Report report);
}
