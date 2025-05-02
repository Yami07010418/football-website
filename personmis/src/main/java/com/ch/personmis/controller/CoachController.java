package com.ch.personmis.controller;

import com.ch.personmis.entity.BUserEntity;
import com.ch.personmis.entity.CoachEntity;
import com.ch.personmis.entity.UserEntity;
import com.ch.personmis.http.ResponseResult;
import com.ch.personmis.service.AdminService;
import com.ch.personmis.service.CoachService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class CoachController {
    @Resource
    private CoachService coachService;
//    @PostMapping(value = "/login1")
//    public String login(@RequestBody CoachEntity coachEntity, HttpSession session) {
//        return coachService.login(coachEntity, session);
//    }

    @PostMapping(value = "/login1")
    public  ResponseResult<Map<String, String>> login(@RequestBody CoachEntity coachEntity) {
        return coachService.login(coachEntity);
    }


    @PostMapping("/register")
    public ResponseResult<Map<String, String>> register(@RequestBody CoachEntity bUserEntity){
        return coachService.register(bUserEntity);
    }
}
