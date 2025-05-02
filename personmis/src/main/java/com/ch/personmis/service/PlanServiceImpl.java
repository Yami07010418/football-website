package com.ch.personmis.service;

import com.ch.personmis.entity.*;
import com.ch.personmis.http.ResponseResult;
import com.ch.personmis.repository.DepartRepository;
import com.ch.personmis.repository.PlanRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.*;

@Service
public class PlanServiceImpl implements PlanService {
    @Resource
    private PlanRepository planRepository;
    @Override
    public List<Plan> selectPlan() {
        return planRepository.selectPlan(null);
    }
    @Override
    public String addPlan(Plan plan ) {
        if(planRepository.addPlan(plan) > 0)
            return "ok";
        return "no";
    }
//教练不同所以要根据教练id来查询不同的教练的plan
    @Override
    public  Map<String, Object>  getPlansByUid(Plan plan) {
        try {

            int currentPage = plan.getCurrentPage();
            int pageSize = plan.getPageSize(); //每页条数
            int totalCount = 0;
            List<Map<String, Object>> plan1 = new ArrayList<>();
            if (plan.getCoach_id() != null && plan.getCoach_id() > 0) {
                totalCount = planRepository.getPlansNumByUid(plan.getCoach_id());
                plan1 = planRepository.getPlansByIdAndPage(plan.getCoach_id(), (currentPage - 1) * pageSize, pageSize);
            }
//            int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
            Map<String, Object> myres = new HashMap<>();
            myres.put("plans", plan1);
            myres.put("total", totalCount);
            return myres;
        }

        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }


//    @Override
//    public ResponseResult<Map<String, Object>> getOrdersByUid(OrdersEntity ordersEntity) {
//        try{
//            int currentPage = ordersEntity.getCurrentPage();
//            int pageSize = 2; //每页条数
//            int totalCount = 0;
//            List<Map<String, Object>> orders = new ArrayList<>();
//            if(ordersEntity.getBusertable_id() != null && ordersEntity.getBusertable_id() > 0)
//            {
//                totalCount = ordersMapper.getOrdersNumByUid(ordersEntity.getBusertable_id());
//                orders = ordersMapper.getOrdersByUidAndPage(ordersEntity.getBusertable_id(), (currentPage-1)*pageSize, pageSize);
//            }
//            int totalPage = (int)Math.ceil(totalCount*1.0/pageSize);
//            Map<String, Object> myres = new HashMap<>();
//            myres.put("ordersByUid", orders);
//            myres.put("totalPage", totalPage);
//            return ResponseResult.getSuccessResult(myres);
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//            return null;
//        }
//    }

//    @Override
//    public Map<String, Object> selectPlanByPage(PlanByCon planByCon) {
//
//
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        planByCon.setAct("byPage");
//        List<Plan> plans = planRepository.selectPlan(planByCon);
//        map.put("plans", plans);
//        planByCon.setAct("byNoPage");
//        map.put("total", planRepository.selectPlan(planByCon).size());
//        return map;
//    }

    @Override
    public Map<String, Object> selectPlansByCon(PlanByCon planByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        planByCon.setAct("byPage");
        List<Plan> plans = planRepository.selectPlansByCon(planByCon);
        map.put("plans", plans);
        planByCon.setAct("byNoPage");
        map.put("total", planRepository.selectPlansByCon(planByCon).size());
        return map;
    }

    @Override
    public Map<String, Object> getPlanDetail(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Plan> plans = planRepository.selectPlan(null);
        map.put("plans", plans);
        Plan aPlan = planRepository.getPlanDetail(id);
        map.put("aPlan", aPlan);
        return map;
    }

    @Override
    public String updatePlan(Plan plan) {
        if(planRepository.updatePlan(plan) > 0)
            return "ok";
        return "no";
    }

    @Override
    public String deletePlan(int id) {
        //先查询是否有关联数据
        List<Map<String, Object>>  listMap =planRepository.selectAssociatePlan(id);
        if (listMap.size() <= 0) {
            if (planRepository.deletePlan(id) > 0)
                return "ok";
        }
        return "no";
    }
}
