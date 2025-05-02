package com.ch.personmis.controller;

import com.ch.personmis.entity.UserEntity;
import com.ch.personmis.service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {
    @Resource
    private AdminService adminService;
    @PostMapping(value = "/login")
    public String login(@RequestBody UserEntity userEntity, HttpSession session) {
        return adminService.login(userEntity, session);
    }
}
//<if test="sname != null and sname != ''"> and s.sname like concat('%',#{sname},'%')</if>：
//
//这是一个条件判断块，用于根据参数中的 sname 属性是否为空来动态拼接查询条件。
//如果 sname 不为空，则将其作为模糊查询条件加入到 SQL 语句中。