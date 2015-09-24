package com.hsogoo.gamestorm.dao.gameCategory.impl;

import com.hsogoo.gamestorm.dao.gameCategory.GameCategoryDao;
import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;

/**
 * Created by weile on 15/9/24.
 */
public class GameCategoryDaoImpl implements GameCategoryDao {

    public Game findExsitCategorysGameByGameId(Long gameId) {
        return null;
    }

    public Category findExsitGamesByCategoryId(Long categoryId) {
        return null;
    }

    public int insertGameAndCategoryRelation(Long gameId, Long categoryId) {
        return 0;
    }

    public int updateGameAndCategoryRelation(Long gameId, Long categoryId) {
        return 0;
    }
}
