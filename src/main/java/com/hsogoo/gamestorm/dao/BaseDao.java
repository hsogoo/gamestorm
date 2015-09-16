package com.hsogoo.gamestorm.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author hsogoo
 * @time 2015-9-13 下午03:06:06
 * @description
 */
public class BaseDao extends SqlMapClientDaoSupport {
	
	@Resource(name="sqlMapClient")
	private SqlMapClient sqlMapClient;
	
	@PostConstruct  //完成sqlMapClient初始化工作
    public void initSqlMapClient(){
           super.setSqlMapClient(sqlMapClient);
    }

	
}
