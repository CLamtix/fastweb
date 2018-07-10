package com.fast.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fast.dao.IUserDao;
import com.fast.service.IUserService;

@Service
public class UserServiceImpl<T> extends BaseServiceImpl<T> implements IUserService<T> {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	@PostConstruct
	protected void setBaseDao() {
		this.baseDao = userDao;
	}

	public boolean checkLoginPasswordByLoginName(String loginName,String password){
		boolean flag = false;
		
		return flag;
	}
	
	public boolean checkLoginPasswordByEmail(String email,String password){
		boolean flag = false;
		
		return flag;
	}

}
