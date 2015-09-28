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
	public ModelAndView getSelectGames(
			ModelAndView model,
			@RequestParam(value = "gameId",required = false) Long gameId,
			@RequestParam(value = "gameName",required = false) String gameName
			){
		List<Game> games = gameCategoryService.getAllCanSelectGames(gameId,gameName);
		model.addObject("games", games);
		return model;
	}

	@RequestMapping("/selectCategorys")
	public ModelAndView selectCategorys(ModelAndView model,
										@RequestParam(value = "categoryId",required = false) Long categoryId,
										@RequestParam(value = "categoryName",required = false) String categoryName){
		List<Category> categories = gameCategoryService.getAllCanSelectCategorys(categoryId, categoryName);
		model.addObject("categories", categories);
		return model;
	}



	@RequestMapping("/doAddGameCategory")
	public ModelAndView doAddGameCategory(@RequestParam(value = "gameId") Long gameId
			,@RequestParam(value = "categoryId") Long categoryId){
		gameCategoryService.saveGameCategoryRelation(gameId,categoryId);
		ModelAndView model = new ModelAndView("redirect:/backend/gameCategory/manage");
		return model;
	}

	
}
