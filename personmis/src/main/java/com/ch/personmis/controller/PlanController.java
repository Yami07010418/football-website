package com.ch.personmis.controller;

import com.ch.personmis.entity.Depart;
import com.ch.personmis.entity.DepartByCon;
import com.ch.personmis.entity.Plan;
import com.ch.personmis.entity.PlanByCon;
import com.ch.personmis.http.ResponseResult;
import com.ch.personmis.service.DepartService;
import com.ch.personmis.service.PlanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class PlanController {
    @Resource
    private PlanService planService;
    @GetMapping("/getPlan")
    public List<Plan> selectPlan() {
        return planService.selectPlan();
    }

    @PostMapping("/getPlansByUid")
    public Map<String, Object> getOrdersByUid(@RequestBody Plan plan){

        return planService.getPlansByUid(plan);
    }
//    @GetMapping("/getPlanByPage")
//    public Map<String, Object> selectPlanByPage(PlanByCon planByCon) {
//        return planService.selectPlanByPage(planByCon);
//    }

//    @GetMapping("/getPlanByPage")
//    public Map<String, Object> selectPlanByPage(PlanByCon planByCon) {
//        return planService.selectPlanByPage(planByCon);
//    }

    @PostMapping("/addPlan")
    public  String addPlan(@RequestBody Plan plan){
        return  planService.addPlan(plan);
    }
    @PostMapping("/selectPlansByCon")
    public Map<String, Object> selectPlansByCon(@RequestBody PlanByCon planByCon) {
        return planService.selectPlansByCon(planByCon);
    }
    @GetMapping("/getPlanDetail")
    public Map<String, Object> getPlanDetail(int id){
        return planService.getPlanDetail(id);
    }
    @PostMapping("/updatePlan")
    public  String updatePlan(@RequestBody Plan plan){
        return  planService.updatePlan(plan);
    }
    @PostMapping("/deletePlan")
    public  String deletePlan(int id){
        return planService.deletePlan(id);
    }
}
