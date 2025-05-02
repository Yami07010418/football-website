package com.ch.personmis.service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.ch.personmis.entity.UserEntity;
import com.ch.personmis.repository.AdminRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
	@Resource
	private  AdminRepository adminRepository;
	@Override
	public String login(UserEntity userEntity, HttpSession session) {
		UserEntity user = adminRepository.login(userEntity);
		if(user != null) {
			session.setAttribute("auser", user);
			UserEntity userEntity1= (UserEntity) session.getAttribute("auser");
			System.out.println(userEntity1.getId());
//			您将用户对象存储到 HttpSession 中，并通过 getAttribute() 方法获取存储在 HttpSession 中的用户对象，然后打印其 ID 并返回 "ok"。在登录失败时，返回 "no"。
			//存在session 会话中session.setAttribute("auser", user);：将登录成功的用户信息存储到会话（Session）中，使用名为 "auser" 的属性名，以便后续在会话中获取用户信息。
			return "ok";
		}else {
			return "no";
		}
	}
}
