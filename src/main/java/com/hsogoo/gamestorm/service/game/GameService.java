package com.hsogoo.gamestorm.service.game;

import java.util.List;

import com.hsogoo.gamestorm.vo.Game;

/**
 * @author hsogoo
 * @time 2015-9-21 下午11:11:08
 * @description
 */
public interface GameService {
	
	/**
	 * 获取所有的游戏列表
	 * @return
	 */
	List<Game> getAllGameList();
	
}
