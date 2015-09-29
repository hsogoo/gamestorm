package com.hsogoo.gamestorm.dao.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<User> getPageUserList(int page, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer start = (page - 1) * pageSize;
		Integer offset = pageSize;
		map.put("start", start);
		map.put("offset", offset);
		return this.getSqlMapClientTemplate().queryForList("gs_user.getPageUserList", map);
	}

	@Override
	public List<UserLevel> getAllUserLevelList() {
		return this.getSqlMapClientTemplate().queryForList("gs_user_level.getAllUserLevelList");
	}

}
