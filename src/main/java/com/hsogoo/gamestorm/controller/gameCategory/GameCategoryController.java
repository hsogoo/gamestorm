package com.hsogoo.gamestorm.controller.gameCategory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.game.GameService;
import com.hsogoo.gamestorm.vo.Game;

/**
 * @author hsogoo
 * @time 2015-9-21 下午10:40:32
 * @description
 */
@Controller
@RequestMapping("/backend/gameCategory")
public class GameCategoryController {
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/manage")
	public String getGameCategoryPage(ModelAndView model){
		return "/backend/gameCategory/gameCategoryManager";
	}
	
	@RequestMapping("/gameCategoryList")
	@ResponseBody
	public ModelAndView getGameCategoryList(ModelAndView model,@RequestParam (value ="page") String page){
		List<Game> gameList = gameService.getAllGameList();
		model.setViewName("/backend/gameCategory/gameCategoryList");
		model.addObject("currentPage", page);
		//TODO:分页查询
		model.addObject("totalPage", gameList.size());
		model.addObject("gameCategoryList", gameList);
		return model;
	}
	
	@RequestMapping("/doAddGameCategory")
	public ModelAndView doAddGameCategory(Game game){
		gameService.addGame(game);
		ModelAndView model = new ModelAndView("redirect:/backend/gameCategory/manage");
		return model;
	}
	
	@RequestMapping("/doAddCategoryGame")
	public ModelAndView doAddCategoryGame(Game game){
		gameService.addGame(game);
		ModelAndView model = new ModelAndView("redirect:/backend/gameCategory/manage");
		return model;
	}
	
}
