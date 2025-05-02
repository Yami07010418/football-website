package com.ch.personmis.repository;

import com.ch.personmis.entity.Depart;
import com.ch.personmis.entity.DepartByCon;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DepartRepository {
    List<Depart> selectDepart(DepartByCon departByCon);
    int addDepart(Depart depart);
    List<Depart> selectDepartmentsByCon(DepartByCon departByCon);
    Depart getDepartmentDetail(int id);
    int updateDepartment(Depart depart);
    List<Map<String, Object>> selectAssociateDepart(int id);
    int deleteDepart(int id);
}
