package com.hsogoo.gamestorm.dao.gameCategory.impl;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.gameCategory.GameCategoryDao;
import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;
import com.hsogoo.gamestorm.vo.GameCategory;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.BackingStoreException;

/**
 * Created by weile on 15/9/24.
 */
@Repository
public class GameCategoryDaoImpl extends BaseDao implements GameCategoryDao {

    public List<Long> findExsitCategoryIdsByGameId(Long gameId) {
        return this.getSqlMapClientTemplate().queryForList("game_category.findExsitCategoryIdsByGameId",gameId);
    }

    public List<Long> findExsitGameIdsByCategoryId(Long categoryId) {
        return this.getSqlMapClientTemplate().queryForList("game_category.findExsitGameIdsByCategoryId",categoryId);
    }

    public void insertGameAndCategoryRelation(Long gameId, Long categoryId) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("gameId",gameId);
        map.put("categoryId",categoryId);
        this.getSqlMapClientTemplate().insert("game_category.insertGameAndCategoryRelation",map);
    }

    public int updateGameAndCategoryRelation(Long id,Long gameId, Long categoryId,Boolean status) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("gameId",gameId);
        map.put("categoryId", categoryId);
        map.put("status", status);
        map.put("id", id);
        return getSqlMapClientTemplate().update("game_category.updateGameAndCategoryRelation", map);
    }

	@Override
	public List<GameCategory> getAllGameCategoryList() {
		return getSqlMapClientTemplate().queryForList("game_category.getAllGameCategoryList");
	}
}
