package com.hsogoo.gamestorm.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsogoo.gamestorm.dao.user.UserDao;
import com.hsogoo.gamestorm.service.user.UserService;
import com.hsogoo.gamestorm.vo.User;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:29:27
 * @description
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public User getUserById(Long userId){
//		User user = new User();
//		user.setId(1L);
//		user.setUserName("hsogoo");
//		user.setPassword("123456");
//		return user;
		return userDao.getUserById(userId);
	}
}

