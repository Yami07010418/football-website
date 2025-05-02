package com.ch.personmis.service;

import com.ch.personmis.entity.BUserEntity;
import com.ch.personmis.entity.CoachEntity;
import com.ch.personmis.entity.UserEntity;
import com.ch.personmis.http.ResponseResult;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface CoachService {
	ResponseResult<Map<String, String>> login(CoachEntity bUserEntity);
//	public String login(CoachEntity coachEntity, HttpSession session);
	ResponseResult<Map<String, String>> register(CoachEntity bUserEntity);

}
    