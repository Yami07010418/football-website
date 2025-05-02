package com.ch.personmis.service;

import javax.servlet.http.HttpSession;

import com.ch.personmis.entity.UserEntity;

public interface AdminService {
	public String login(UserEntity userEntity, HttpSession session);

}
    