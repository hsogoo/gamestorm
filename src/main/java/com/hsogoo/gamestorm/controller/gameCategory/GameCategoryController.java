package com.hsogoo.gamestorm.controller.gameCategory;

import java.util.List;

import com.hsogoo.gamestorm.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.gameCategory.GameCategoryService;
import com.hsogoo.gamestorm.vo.Game;
import com.hsogoo.gamestorm.vo.GameCategory;

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
	
	@RequestMapping("/manage")
	public ModelAndView getGameCategoryPage(ModelAndView model){
		List<GameCategory> gameCategoryList = gameCategoryService.getAllGameCategoryList();
		model.setViewName("/backend/gameCategory/gameCategoryManager");
		model.addObject("gameCategoryList", gameCategoryList);
		return model;
	}

	@RequestMapping("/selectGames")
	public @ResponseBody List<Game> getSelectGames(
			@RequestParam(value = "searchGameId",required = false) Long searchGameId,
			@RequestParam(value = "searchGameName",required = false) String searchGameName
			){
		return gameCategoryService.getAllCanSelectGames(searchGameId,searchGameName);
	}

	@RequestMapping("/selectCategorys")
	public @ResponseBody List<Category> selectCategorys(
										@RequestParam(value = "searchCategoryId",required = false) Long searchCategoryId,
										@RequestParam(value = "searchCategoryName",required = false) String searchCategoryName){
		return gameCategoryService.getAllCanSelectCategorys(searchCategoryId, searchCategoryName);
	}



	@RequestMapping("/doAddGameCategory")
	public ModelAndView doAddGameCategory(@RequestParam(value = "gameId") Long gameId
			,@RequestParam(value = "categoryId") Long categoryId){
		gameCategoryService.saveGameCategoryRelation(gameId,categoryId);
		ModelAndView model = new ModelAndView("redirect:/backend/gameCategory/manage");
		return model;
	}

	
}
