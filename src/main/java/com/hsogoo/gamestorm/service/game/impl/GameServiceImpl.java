package com.hsogoo.gamestorm.service.game.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsogoo.gamestorm.dao.game.GameDao;
import com.hsogoo.gamestorm.service.game.GameService;
import com.hsogoo.gamestorm.vo.Game;

/**
 * @author hsogoo
 * @time 2015-9-21 下午11:13:23
 * @description
 */
@Service
public class GameServiceImpl implements GameService{
	
	@Autowired
	private GameDao gameDao;
	public List<Game> getAllGameList() {
		return gameDao.getAllGameList();
	}
	public void addGame(Game game) {
		gameDao.addGame(game);
	}

}
