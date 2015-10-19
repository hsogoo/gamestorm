package com.hsogoo.gamestorm.dao.game.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<Game> getAllGameList() {
		return this.getSqlMapClientTemplate().queryForList("gs_game.getAllGameList");
	}

	public void addGame(Game game) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gameName", game.getGameName());
		map.put("iconImage", game.getIconImage());
		map.put("displayImage", game.getDisplayImage());
		map.put("bannerImage", game.getBannerImage());
		map.put("isRecommended", game.getIsRecommended());
		this.getSqlMapClientTemplate().insert("gs_game.addGame",map);
	}

	public List<Game> findFuzzyGames(Long gameId, String gameName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id",gameId);
		map.put("gameName",gameName);
		return this.getSqlMapClientTemplate().queryForList("gs_game.findFuzzyGames",map);
	}

	public List<Game> getAllUseGameList() {
		return this.getSqlMapClientTemplate().queryForList("gs_game.getAllUseGameList");
	}

	public Game getGameById(Long gameId) {
		return (Game) getSqlMapClientTemplate().queryForObject("gs_game.getGameById",gameId);
	}
}
