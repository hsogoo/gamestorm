package com.hsogoo.gamestorm.dao.user.impl;

import org.springframework.stereotype.Repository;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.user.UserDao;
import com.hsogoo.gamestorm.vo.User;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:25:33
 * @description
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Override
	public User getUserById(Long userId) {
		return (User) this.getSqlMapClientTemplate().queryForObject("gs_user.getUserById", userId);
	}

}
