package com.hsogoo.gamestorm.service.gameCategory.impl;

import java.util.*;

import com.hsogoo.gamestorm.dao.category.CategoryDao;
import com.hsogoo.gamestorm.dao.game.GameDao;
import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsogoo.gamestorm.dao.gameCategory.GameCategoryDao;
import com.hsogoo.gamestorm.service.gameCategory.GameCategoryService;
import com.hsogoo.gamestorm.vo.GameCategory;
import org.springframework.util.CollectionUtils;

/**
 * Created by weile on 15/9/24.
 */
@Service
public class GameCategoryServiceImpl implements GameCategoryService {

	@Autowired
	private GameCategoryDao gameCategoryDao;

	@Autowired
	private GameDao gameDao;

	@Autowired
	private CategoryDao categoryDao;
	
	public List<GameCategory> getAllGameCategoryList() {
		return gameCategoryDao.getAllGameCategoryList();
	}

	public List<Game> getAllCanSelectGames(Long gameId, String gameName) {
		//模糊查询所有的游戏列表
		List<Game> games = gameDao.findFuzzyGames(gameId,gameName);

		//games List转Map
		Map<String,Game> gameMap = new HashMap<String,Game>();
		for(Game  game:games){
			if(game == null){
				continue;
			}
			gameMap.put(game.getId().toString(), game);
		}

		//查询所有可用的类别列表
		List<Category> categories = categoryDao.findFuzzyCategorys(null, null);

		//循环类别列表，去掉重复的已有分类的Game
		for(Category category : categories){
			List<Long> excludeGameIds = gameCategoryDao.findExsitGameIdsByCategoryId(category.getId());
			if(!CollectionUtils.isEmpty(excludeGameIds)){
				for(Long tempGameId : excludeGameIds){
					if(gameMap.get(tempGameId) != null){
						gameMap.remove(tempGameId);
					}
				}
			}
		}

		//Map 转 list
		List<Game> resultList = new ArrayList<Game>();
		Iterator it = gameMap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			resultList.add(gameMap.get(key));
		}

		return resultList;
	}

	public List<Category> getAllCanSelectCategorys(Long categoryId, String categoryName) {
		//模糊查询所有的分类列表
		List<Category> categories = categoryDao.findFuzzyCategorys(categoryId,categoryName);

		//categories List转Map
		Map<String,Category> categoryHashMap = new HashMap<String,Category>();
		for(Category  category:categories){
			if(category == null){
				continue;
			}
			categoryHashMap.put(category.getId().toString(), category);
		}

		//查询所有可用的游戏列表
		List<Game> games = gameDao.findFuzzyGames(null, null);

		//循环类别列表，去掉重复的已有分类的Game
		for(Game game : games){
			List<Long> excludeCategoryIds = gameCategoryDao.findExsitCategoryIdsByGameId(game.getId());
			if(!CollectionUtils.isEmpty(excludeCategoryIds)){
				for(Long tempCategoryId : excludeCategoryIds){
					if(categoryHashMap.get(tempCategoryId) != null){
						categoryHashMap.remove(tempCategoryId);
					}
				}
			}
		}

		//Map 转 list
		List<Category> resultList = new ArrayList<Category>();
		Iterator it = categoryHashMap.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			resultList.add(categoryHashMap.get(key));
		}

		return resultList;
	}


	public void saveGameCategoryRelation(Long gameId, Long categoryId) {
		gameCategoryDao.insertGameAndCategoryRelation(gameId,categoryId);
	}
}
