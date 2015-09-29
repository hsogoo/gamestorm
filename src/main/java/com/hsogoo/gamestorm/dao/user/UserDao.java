package com.hsogoo.gamestorm.dao.user;

import java.util.List;

import com.hsogoo.gamestorm.vo.User;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:22:08
 * @description
 */
public interface UserDao {
	
	public User getUserById(Long userId);

	public List<User> getAllUserList();

	public List<User> getPageUserList(int page, int pageSize);
	
	public Long getTotalUserCount();

	public List<UserLevel> getAllUserLevelList();
	
}
