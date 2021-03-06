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

	public List<Game> getAllUseGameList();

	public void addGame(Game game);

	/**
	 * 根据游戏名称和id模糊查询游戏信息
	 * @param gameName
	 * @return
	 */
	public List<Game> findFuzzyGames(Long gameId,String gameName);

	/**
	 * 根据游戏id获取游戏信息
	 * @param gameId
	 * @return
	 */
	public Game getGameById(Long gameId);
}
