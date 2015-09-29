package com.hsogoo.gamestorm.dao.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.user.UserDao;
import com.hsogoo.gamestorm.vo.User;
import com.hsogoo.gamestorm.vo.UserLevel;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:25:33
 * @description
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
	
	public User getUserById(Long userId) {
		return (User) this.getSqlMapClientTemplate().queryForObject("gs_user.getUserById", userId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUserList() {
		return this.getSqlMapClientTemplate().queryForList("gs_user.getAllUserList");
	}
	
	public Long getTotalUserCount(){
		Long count = (Long)this.getSqlMapClientTemplate().queryForObject("gs_user.getTotalUserCount");
		if(count == null){
			return 0L;
		}else{
			return count;
		}
	}

	@Override
	public List<User> getPageUserList(int page, int pageSize, String userName, String userEmail) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer start = (page - 1) * pageSize;
		Integer offset = pageSize;
		map.put("start", start);
		map.put("offset", offset);
		map.put("userName", userName);
		map.put("userEmail", userEmail);
		return this.getSqlMapClientTemplate().queryForList("gs_user.getPageUserList", map);
	}

	@Override
	public List<UserLevel> getAllUserLevelList() {
		return this.getSqlMapClientTemplate().queryForList("gs_user_level.getAllUserLevelList");
	}

	@Override
	public void addUserLevel(UserLevel userLevel) {
		this.getSqlMapClientTemplate().insert("gs_user_level.addUserLevel", userLevel);
	}

	@Override
	public void updateUserLevel(UserLevel userLevel) {
		this.getSqlMapClientTemplate().update("gs_user_level.updateUserLevel", userLevel);
	}

}
