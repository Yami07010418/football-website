package com.ch.personmis.repository;

import com.ch.personmis.entity.Depart;
import com.ch.personmis.entity.DepartByCon;
import com.ch.personmis.entity.Plan;
import com.ch.personmis.entity.PlanByCon;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PlanRepository {
    List<Plan> selectPlan(PlanByCon planByCon);
    int addPlan(Plan plan);
    List<Plan> selectPlansByCon(PlanByCon planByCon);
    Plan getPlanDetail(int id);
    int updatePlan(Plan plan);
    List<Map<String, Object>> selectAssociatePlan(int id);
    int deletePlan(int id);
    int getPlansNumByUid(int coach_id);
    List<Map<String, Object>> getPlansByIdAndPage(int id, int startIndex, int perPageSize);
}
