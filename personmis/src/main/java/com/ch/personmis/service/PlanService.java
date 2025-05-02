package com.ch.personmis.service;

import com.ch.personmis.entity.Depart;
import com.ch.personmis.entity.DepartByCon;
import com.ch.personmis.entity.Plan;
import com.ch.personmis.entity.PlanByCon;
import com.ch.personmis.http.ResponseResult;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface PlanService {
    List<Plan> selectPlan();
    String addPlan(Plan plan);
//    Map<String, Object> selectPlanByPage(PlanByCon planByCon);
    Map<String, Object> selectPlansByCon(PlanByCon planByCon);
    Map<String, Object> getPlanDetail(int id);
    String updatePlan(Plan plan);
    String deletePlan(int id);
    Map<String, Object> getPlansByUid(Plan plan);
}
