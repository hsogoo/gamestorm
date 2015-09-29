package com.hsogoo.gamestorm.service.user;

import java.util.List;

import com.hsogoo.gamestorm.vo.User;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:19:42
 * @description
 */
public interface UserService {

	public User getUserById(Long userId);
	
	public List<User> getAllUserList();
	
	public List<User> getPageUserList(int page,int pageSize);
	
	public Long getTotalUserCount();
	
	public List<UserLevel> getAllUserLevelList();
}
