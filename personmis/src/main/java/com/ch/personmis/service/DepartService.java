package com.ch.personmis.service;

import com.ch.personmis.entity.Depart;
import com.ch.personmis.entity.DepartByCon;

import java.util.List;
import java.util.Map;

public interface DepartService {
    List<Depart> selectDepart();
    String addDepartment(Depart depart);
    Map<String, Object> selectDepartByPage(DepartByCon departByCon);
    Map<String, Object> selectDepartmentsByCon(DepartByCon departByCon);
    Map<String, Object> getDepartmentDetail(int id);
    String updateDepartment(Depart depart);
    String deleteDepartment(int id);
}
