package com.ch.personmis.controller;

import com.ch.personmis.entity.*;
import com.ch.personmis.service.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class StaffController {
    @Resource
    private StaffService staffService;
    @PostMapping("/addStaff")//前端接受的数据长什么样子
    public  String addStaff(@RequestBody Staff staff ){
        return staffService.addStaff(staff);
    }
//    Postmapping 作用是用来告诉这是一个添加的请求 里面的代码就执行添加的操作
//@RequestBody主要用来接收前端传递给后端的json字符串中的数据,requestbody 用于postmapping  添加数据所以需要一个参数用来接收参数
//Getmapping 作用是告诉这是一个get请求，里面代码执行得到数据的操作
    @GetMapping("/getStaffByPage")
    public Map<String, Object> selectStaffByPage(StaffByCon staffByCon) {
        return staffService.selectStaffByPage(staffByCon);
    }
    @PostMapping("/selectStaffByCon")
    public Map<String, Object> selectStaffByCon(@RequestBody StaffByCon staffByCon){
        return staffService.selectStaffByCon(staffByCon);
    }
    @GetMapping("/getStaffDetail")
    public Staff getStaffDetail(int id){
        return staffService.getStaffDetail(id);
    }
    @PostMapping("/updateStaff")
    public  String updateStaff(@RequestBody Staff staff ){
        return staffService.updateStaff(staff);
    }
    //试用期管理
    @GetMapping("/getPeriods")
    public Map<String, Object> selectPeriodsByPage(PeriodByCon periodByCon) {
        return staffService.selectPeriodsByPage(periodByCon);
    }
    @PostMapping("/selectPeriodByCon")
    public Map<String, Object> selectPeriodByCon(@RequestBody PeriodByCon periodByCon){
        return staffService.selectPeriodByCon(periodByCon);
    }
    @PostMapping("/periodOp")
    public String periodOp(int id, String status){
        return staffService.periodOp(id, status);
    }
    @PostMapping("/deleteStaff")
    public  String deleteStaff(int id){
        return staffService.deleteStaff(id);
    }
    @GetMapping("/getstaff")
    public Map<String, Object> selectStaff() {
//        System.out.println();
        return staffService.selectStaff();
    }
//    @GetMapping("/getstaff")
//    public List<Staff> getstaff() {
//        return staffService.getStaff();
//    }
//    public String getStaff()

}
