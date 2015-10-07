package com.hsogoo.gamestorm.controller.gameCategory;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.constant.ResultConstant;
import com.hsogoo.gamestorm.service.category.CategoryService;
import com.hsogoo.gamestorm.service.game.GameService;
import com.hsogoo.gamestorm.service.gameCategory.GameCategoryService;
import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;
import com.hsogoo.gamestorm.vo.GameCategory;
import com.hsogoo.gamestorm.vo.JsonResult;

/**
 * @author hsogoo
 * @time 2015-9-21 下午10:40:32
 * @description
 */
@Controller
@RequestMapping("/backend/gameCategory")
public class GameCategoryController {
	
	@Autowired
	private GameCategoryService gameCategoryService;
	@Autowired
	private GameService gameService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/manage")
	public ModelAndView getGameCategoryPage(ModelAndView model){
		List<GameCategory> gameCategoryList = gameCategoryService.getAllGameCategoryList();
		List<Game> gameList = gameService.getAllGameList();
		List<Category> categoryList = categoryService.getAllCategoryList();
		model.setViewName("/backend/gameCategory/gameCategoryManager");
		model.addObject("gameCategoryList", gameCategoryList);
		model.addObject("gameList", gameList);
		model.addObject("categoryList", categoryList);
		return model;
	}

//	@RequestMapping("/selectGames")
//	public @ResponseBody List<Game> getSelectGames(
//			@RequestParam(value = "searchGameId",required = false) Long searchGameId,
//			@RequestParam(value = "searchGameName",required = false) String searchGameName
//			){
//		return gameCategoryService.getAllCanSelectGames(searchGameId,searchGameName);
//	}
//
//	@RequestMapping("/selectCategorys")
//	public @ResponseBody List<Category> selectCategorys(
//										@RequestParam(value = "searchCategoryId",required = false) Long searchCategoryId,
//										@RequestParam(value = "searchCategoryName",required = false) String searchCategoryName){
//		return gameCategoryService.getAllCanSelectCategorys(searchCategoryId, searchCategoryName);
//	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/addGameCategory")
	@ResponseBody
	public JsonResult addGameCategory(GameCategory gameCategory){
		JsonResult jsonResult = new JsonResult();
		List<GameCategory> oldGameCategory = gameCategoryService.getGameCategoryByGameIdAndCategoryId(gameCategory.getGameId(), gameCategory.getCategoryId());
		if(CollectionUtils.isNotEmpty(oldGameCategory)){
			jsonResult.setCode(ResultConstant.ERROR_EXIST_CODE);
			jsonResult.setMessage(ResultConstant.ERROR_EXIST_MSG);
			return jsonResult;
		}
		gameCategoryService.addGameCategory(gameCategory);
		jsonResult.setCode(ResultConstant.SUCCESS);
		return jsonResult;
	}
}
