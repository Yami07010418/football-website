package com.ch.personmis.service;

import com.ch.personmis.entity.BUserEntity;
import com.ch.personmis.entity.CoachEntity;
import com.ch.personmis.entity.UserEntity;
import com.ch.personmis.http.ResponseResult;
import com.ch.personmis.repository.AdminRepository;
import com.ch.personmis.repository.CoachRepository;
import com.ch.personmis.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoachServiceImpl implements CoachService{
	@Resource
	private CoachRepository coachRepository;

	@Override
	public ResponseResult<Map<String, String>> login(CoachEntity coachEntity) {
		//链式query
		long res = coachRepository.isUse(coachEntity).size();
		if(res == 0) {
			// 用户名不存在
			return ResponseResult.getMessageResult(null, "A001");
		}
		Map<String, String> mapparam = new HashMap<>();
		coachEntity.setUpwd(MD5Util.MD5(coachEntity.getUpwd()));
		mapparam.put("aname", coachEntity.getUname());
		mapparam.put("apwd", coachEntity.getUpwd());
		List<CoachEntity> mu = coachRepository.login(coachEntity);
		if(mu.size() > 0){//登录成功
			Map<String, String> myres = new HashMap<>();
			myres.put("aname", coachEntity.getUname());
			myres.put("bid", mu.get(0).getId()+"");
			return ResponseResult.getSuccessResult(myres);
		}else{//密码错误
			return ResponseResult.getMessageResult(null, "A002");
		}
	}

//	@Override
//	public String login(CoachEntity coachEntity, HttpSession session) {
//		CoachEntity user = coachRepository.login(coachEntity);
//		if(user != null) {
//			session.setAttribute("buser", user);
//			CoachEntity coachEntity1= (CoachEntity) session.getAttribute("buser");
//			System.out.println(coachEntity1.getId());
//			return "ok";
//		}else {
//			return "no";
//		}
//	}
	public ResponseResult<Map<String, String>> register(CoachEntity bUserEntity) {
		//对明文加密
		bUserEntity.setUpwd(MD5Util.MD5(bUserEntity.getUpwd()));
		long n = coachRepository.isUse(bUserEntity).size();
		if(n > 0 ) {//邮箱已注册
			return ResponseResult.getMessageResult(null, "A001");
		} else if(coachRepository.register(bUserEntity) > 0) {//注册成功
			return ResponseResult.getMessageResult(null, "A002");
		} else {//注册失败
			return ResponseResult.getMessageResult(null, "A003");
		}
	}
}
