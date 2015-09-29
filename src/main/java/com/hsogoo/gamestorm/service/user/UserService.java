package com.hsogoo.gamestorm.service.user;

import java.util.List;

import com.hsogoo.gamestorm.vo.User;
import com.hsogoo.gamestorm.vo.UserLevel;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:19:42
 * @description
 */
public interface UserService {

	public User getUserById(Long userId);
	
	public List<User> getAllUserList();
	
	public List<User> getPageUserList(int page,int pageSize,String userName, String userEmail);
	
	public Long getTotalUserCount();
	
	public List<UserLevel> getAllUserLevelList();

	public void addUserLevel(UserLevel userLevel);

	public void updateUserLevel(UserLevel userLevel);
}
