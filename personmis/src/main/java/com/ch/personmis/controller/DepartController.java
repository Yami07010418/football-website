package com.ch.personmis.controller;

import com.ch.personmis.entity.Depart;
import com.ch.personmis.entity.DepartByCon;
import com.ch.personmis.service.DepartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class DepartController {
    @Resource//表示依赖注入，这里用于将 DepartService 类型的 Bean 注入到 departService 字段中。
    //@Resource：表示依赖注入，Spring 会将名为 departService 的 Bean 注入到 DepartController 类中的 departService 字段中。
    //
    //通过注入 DepartService，DepartController 可以调用其方法来处理与部门相关的业务逻辑。
    private DepartService departService;
    @GetMapping("/getDepartment")
    public List<Depart> selectDepart() {
        return departService.selectDepart();
    }
    @GetMapping("/getDepartmentByPage")
    public Map<String, Object> selectDepartByPage(DepartByCon departByCon) {
        return departService.selectDepartByPage(departByCon);
    }
    @PostMapping("/addDepartment")
    public  String addDepartment(@RequestBody Depart depart){
        return  departService.addDepartment(depart);
    }
    @PostMapping("/selectDepartmentsByCon")
    public Map<String, Object> selectDepartmentsByCon(@RequestBody DepartByCon departByCon) {
        return departService.selectDepartmentsByCon(departByCon);
    }
    @GetMapping("/getDepartmentDetail")
    public Map<String, Object> getDepartmentDetail(int id){
        return departService.getDepartmentDetail(id);
    }
    @PostMapping("/updateDepartment")
    public  String updateDepartment(@RequestBody Depart depart){
        return  departService.updateDepartment(depart);
    }
    @PostMapping("/deleteDepartment")
    public  String deleteDepartment(int id){
        return departService.deleteDepartment(id);
    }
}
