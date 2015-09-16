package com.hsogoo.gamestorm.dao.user;

import org.springframework.stereotype.Repository;

import com.hsogoo.gamestorm.vo.User;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:22:08
 * @description
 */
public interface UserDao {
	
	public User getUserById(Long userId);
	
}
