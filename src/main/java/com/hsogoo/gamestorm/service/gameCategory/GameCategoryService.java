package com.hsogoo.gamestorm.service.gameCategory;

import java.util.List;

import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;
import com.hsogoo.gamestorm.vo.GameCategory;

/**
 * Created by weile on 15/9/24.
 */
public interface GameCategoryService {

	public List<GameCategory> getAllGameCategoryList();

	List<Game> getAllCanSelectGames(Long gameId, String gameName);

	List<Category> getAllCanSelectCategorys(Long categoryId, String categoryName);

	void saveGameCategoryRelation(Long gameId, Long categoryId);
}
