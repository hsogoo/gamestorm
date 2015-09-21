package com.hsogoo.gamestorm.dao.game.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.game.GameDao;
import com.hsogoo.gamestorm.vo.Game;

/**
 * @author hsogoo
 * @time 2015-9-21 下午11:16:56
 * @description
 */
@Repository
public class GameDaoImpl extends BaseDao implements GameDao{

	@Override
	public List<Game> getAllGameList() {
		return this.getSqlMapClientTemplate().queryForList("gs_game.getAllGameList");
	}

}
