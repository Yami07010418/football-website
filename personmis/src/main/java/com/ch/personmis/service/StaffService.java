package com.ch.personmis.service;

import com.ch.personmis.entity.Depart;
import com.ch.personmis.entity.PeriodByCon;
import com.ch.personmis.entity.Staff;
import com.ch.personmis.entity.StaffByCon;

import java.util.List;
import java.util.Map;

public interface StaffService {
    String addStaff(Staff staff );
//    List<Staff> getStaff();
     Map<String, Object> selectStaff();
    Map<String, Object> selectStaffByPage(StaffByCon staffByCon);
    Map<String, Object> selectStaffByCon(StaffByCon staffByCon);
    Staff getStaffDetail(int id);
    String updateStaff(Staff staff );
    Map<String, Object> selectPeriodsByPage(PeriodByCon periodByCon);
    Map<String, Object> selectPeriodByCon(PeriodByCon periodByCon);
    String periodOp(int id, String status);
    String deleteStaff(int id);
}
