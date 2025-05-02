package com.ch.personmis.service;
import com.ch.personmis.entity.*;
import com.ch.personmis.repository.StaffRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffRepository staffRepository;
    @Override
    public String addStaff(Staff staff) {

        if(staffRepository.addStaff(staff) > 0)
            return "ok";
        return "no";
    }
//    @Override
//    public List<Staff> getStaff() {
//        return staffRepository.getStaff(null);
//    }
    @Override
    public Map<String, Object> selectStaff() {
        Map<String, Object> map = new HashMap<String, Object>();
            List<Map<String, Object>> StaffList = staffRepository.getStaff();
            map.put("staff", StaffList);
        return map;
    }
    @Override
    public Map<String, Object> selectStaffByPage(StaffByCon staffByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        staffByCon.setAct("byPage");
        List<Staff> staffs = staffRepository.selectStaff(staffByCon);
        map.put("staffs", staffs);
        staffByCon.setAct("byNoPage");
        map.put("total", staffRepository.selectStaff(staffByCon).size());
        return map;
    }

    @Override
    public Map<String, Object> selectStaffByCon(StaffByCon staffByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        staffByCon.setAct("byPage");
        List<Staff> staffs = staffRepository.selectStaffByCon(staffByCon);
        map.put("staffs", staffs);
        staffByCon.setAct("byNoPage");
        map.put("total", staffRepository.selectStaffByCon(staffByCon).size());
        return map;
    }

    @Override
    public Staff getStaffDetail(int id) {
        return staffRepository.selectAStaff(id);
    }

    @Override
    public String updateStaff(Staff staff) {
        if(staffRepository.updateStaff(staff) > 0)
            return "ok";
        return "no";
    }
    //试用期管理
    @Override
    public Map<String, Object> selectPeriodsByPage(PeriodByCon periodByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        periodByCon.setAct("byPage");
        List<Staff> periods = staffRepository.selectPeriodStaff(periodByCon);
        map.put("periods", periods);
        periodByCon.setAct("byNoPage");
        map.put("total", staffRepository.selectPeriodStaff(periodByCon).size());
        return map;
    }

    @Override
    public Map<String, Object> selectPeriodByCon(PeriodByCon periodByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        periodByCon.setAct("byPage");
        List<Staff> periods = staffRepository.selectPeriodStaffCon(periodByCon);
        map.put("periods", periods);
        periodByCon.setAct("byNoPage");
        map.put("total", staffRepository.selectPeriodStaffCon(periodByCon).size());
        return map;
    }

    @Override
    public String periodOp(int id, String status) {
        if (staffRepository.periodOp(id, status) > 0)
            return "ok";
        return "no";
    }

    @Override
    public String deleteStaff(int id) {
        //先查询是否有关联数据
        List<Map<String, Object>>  listMap =staffRepository.selectAssociateStaff(id);
        if (listMap.size() <= 0) {
            if (staffRepository.deleteStaff(id) > 0)
                return "ok";
        }
        return "no";
    }
}
