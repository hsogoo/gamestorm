package com.hsogoo.gamestorm.controller.gameCategory;

import java.util.List;

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
	
//	@RequestMapping("/gameCategoryList")
//	@ResponseBody
//	public ModelAndView getAllGameCategoryList(ModelAndView model,@RequestParam (value ="page") String page){
//		List<GameCategory> gameCategoryList = gameCategoryService.getAllGameCategoryList();
//		model.setViewName("/backend/gameCategory/gameCategoryList");
//		model.addObject("gameCategoryList", gameCategoryList);
//		return model;
//	}
	
//	@RequestMapping("/doAddGameCategory")
//	public ModelAndView doAddGameCategory(Game game){
//		gameService.addGame(game);
//		ModelAndView model = new ModelAndView("redirect:/backend/gameCategory/manage");
//		return model;
//	}
//	
//	@RequestMapping("/doAddCategoryGame")
//	public ModelAndView doAddCategoryGame(Game game){
//		gameService.addGame(game);
//		ModelAndView model = new ModelAndView("redirect:/backend/gameCategory/manage");
//		return model;
//	}
	
}
