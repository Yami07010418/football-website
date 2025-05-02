package com.ch.personmis.repository;

import com.ch.personmis.entity.PeriodByCon;
import com.ch.personmis.entity.Staff;
import com.ch.personmis.entity.StaffByCon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StaffRepository {
     int addStaff(Staff staff);
     List<Staff> selectStaff(StaffByCon staffByCon);
     List<Map<String,Object>>  getStaff();
//     List<Staff> getStaff(StaffByCon staffByCon);
     List<Staff>  selectStaffByCon(StaffByCon staffByCon);
     Staff selectAStaff(int id);
     int updateStaff(Staff staff);
     List<Staff> selectPeriodStaff(PeriodByCon periodByCon);
     List<Staff> selectPeriodStaffCon(PeriodByCon periodByCon);
     int periodOp(@Param("id") int id, @Param("status") String status);
     List<Map<String, Object>>  selectAssociateStaff(int id);
     int deleteStaff(int id);
}
