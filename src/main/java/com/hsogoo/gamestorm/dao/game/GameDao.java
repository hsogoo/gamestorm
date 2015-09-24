package com.hsogoo.gamestorm.dao.game;

import java.util.List;

import com.hsogoo.gamestorm.vo.Game;

/**
 * @author hsogoo
 * @time 2015-9-21 下午11:16:16
 * @description
 */
public interface GameDao {

	public List<Game> getAllGameList();

	public void addGame(Game game);

	/**
	 * 根据游戏名称和id模糊查询游戏信息
	 * @param gameName
	 * @return
	 */
	public List<Game> findFuzzyGamesByGameName(String gameId,String gameName);
}
