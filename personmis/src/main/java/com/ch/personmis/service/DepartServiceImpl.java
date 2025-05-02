package com.ch.personmis.service;

import com.ch.personmis.entity.Depart;
import com.ch.personmis.entity.DepartByCon;
import com.ch.personmis.repository.DepartRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartServiceImpl implements DepartService {
    @Resource
    private DepartRepository departRepository;
    @Override
    public List<Depart> selectDepart() {
        return departRepository.selectDepart(null);
    }
    @Override
    public String addDepartment(Depart depart) {
        if(departRepository.addDepart(depart) > 0)
            return "ok";
        return "no";
    }

    @Override
    public Map<String, Object> selectDepartByPage(DepartByCon departByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        departByCon.setAct("byPage");
        List<Depart> departs = departRepository.selectDepart(departByCon);
        map.put("departs", departs);
        departByCon.setAct("byNoPage");
        map.put("total", departRepository.selectDepart(departByCon).size());
        return map;
    }
//     selectDepartByPage是分页查询 为了刚打开页面渲染数据的作用
//    selectDepartmentsByCon是按条件查询

    @Override
    public Map<String, Object> selectDepartmentsByCon(DepartByCon departByCon) {
        Map<String, Object> map = new HashMap<String, Object>();
        departByCon.setAct("byPage");
        List<Depart> departs = departRepository.selectDepartmentsByCon(departByCon);
        map.put("departs", departs);
        departByCon.setAct("byNoPage");
        map.put("total", departRepository.selectDepartmentsByCon(departByCon).size());
        return map;
    }
//    创建一个新的 HashMap 来存储结果。创建一个新的 HashMap 实例，用于存储方法的返回结果。这个 Map 的键是字符串类型，值是对象类型。
//将 departByCon 对象的动作（act）参数设置为 "byPage"，表示启用分页。
//    List<Depart> 表示这是一个存储 Depart 对象的列表
//调用 departRepository.selectDepartmentsByCon(departByCon) 来根据条件检索部门列表。
//将检索到的部门列表放入具有键 "departs" 的地图中。
//然后将 departByCon 对象的动作参数设置为 "byNoPage"，表示禁用分页。
//通过调用 departRepository.selectDepartmentsByCon(departByCon).size() 来检索不带分页的部门总数。
//将总数放入具有键 "total" 的地图中。
//最后，返回包含部门列表和总数的填充地图。
//    byNoPage参数是为了获取查询结果的总数，而不是分页查询的结果。因为分页查询只能获取当前页的结果，而不能获取总的结果数量，
//    所以需要设置byNoPage参数，以便获取总的结果数量。设置此属性就不用分页直接能够取得数据库中总共数据的数量因为下面的语句
//    因为加bypage只能查询两个数据 bynopage的话能查所有数据
//map.put("total",departRepository.selectDepart(departByCon).size());这个语句的目的就是为了得到总共的数据

    @Override
    public Map<String, Object> getDepartmentDetail(int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Depart> departs = departRepository.selectDepart(null);
        map.put("departs", departs);
        Depart aDepart = departRepository.getDepartmentDetail(id);
        map.put("aDepart", aDepart);
        return map;
    }

    @Override
    public String updateDepartment(Depart depart) {
        if(departRepository.updateDepartment(depart) > 0)
            return "ok";
        return "no";
    }

    @Override
    public String deleteDepartment(int id) {
        //先查询是否有关联数据
        List<Map<String, Object>>  listMap =departRepository.selectAssociateDepart(id);
        if (listMap.size() <= 0) {
            if (departRepository.deleteDepart(id) > 0)
                return "ok";
        }
        return "no";
    }
}
