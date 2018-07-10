package com.fast.dao.impl;

import org.springframework.stereotype.Repository;

import com.fast.dao.IUserDao;
import com.fast.entity.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao<User> {
	
}
