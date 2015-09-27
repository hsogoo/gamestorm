package com.hsogoo.gamestorm.service.gameCategory.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsogoo.gamestorm.dao.gameCategory.GameCategoryDao;
import com.hsogoo.gamestorm.service.gameCategory.GameCategoryService;
import com.hsogoo.gamestorm.vo.GameCategory;

/**
 * Created by weile on 15/9/24.
 */
@Service
public class GameCategoryServiceImpl implements GameCategoryService {

	@Autowired
	private GameCategoryDao gameCategoryDao;
	
	@Override
	public List<GameCategory> getAllGameCategoryList() {
		return gameCategoryDao.getAllGameCategoryList();
	}
}
