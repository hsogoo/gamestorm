package com.hsogoo.gamestorm.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsogoo.gamestorm.dao.user.UserDao;
import com.hsogoo.gamestorm.service.user.UserService;
import com.hsogoo.gamestorm.vo.User;
import com.hsogoo.gamestorm.vo.UserLevel;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:29:27
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User getUserById(Long userId) {
		// User user = new User();
		// user.setId(1L);
		// user.setUserName("hsogoo");
		// user.setPassword("123456");
		// return user;
		return userDao.getUserById(userId);
	}

	@Override
	public List<User> getAllUserList() {
		return userDao.getAllUserList();
	}

	@Override
	public List<User> getPageUserList(int page, int pageSize, String userName, String userEmail) {
		return userDao.getPageUserList(page, pageSize, userName, userEmail);
	}

	@Override
	public Long getTotalUserCount() {
		return userDao.getTotalUserCount();
	}

	@Override
	public List<UserLevel> getAllUserLevelList() {
		return userDao.getAllUserLevelList();
	}

	@Override
	public void addUserLevel(UserLevel userLevel) {
		userDao.addUserLevel(userLevel);
	}

	@Override
	public void updateUserLevel(UserLevel userLevel) {
		userDao.updateUserLevel(userLevel);
	}

}
