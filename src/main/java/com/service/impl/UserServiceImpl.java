package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.service.UserService;
import com.util.Result;
import com.util.ResultCode;
import com.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserVO getUserInfo(int id) {
		UserVO userInfo = userDao.getUser(id);
		return userInfo;
	}

}
