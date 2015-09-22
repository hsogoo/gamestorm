package com.hsogoo.gamestorm.controller.game;

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
@RequestMapping("/backend/game")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@RequestMapping("/manage")
	public String getGamePage(ModelAndView model){
		return "/backend/game/gameManager";
	}
	
	@RequestMapping("/gameList")
	@ResponseBody
	public ModelAndView getGameList(ModelAndView model,@RequestParam (value ="page") String page){
		List<Game> gameList = gameService.getAllGameList();
		model.setViewName("/backend/game/gameList");
		model.addObject("currentPage", page);
		//TODO:分页查询
		model.addObject("totalPage", gameList.size());
		model.addObject("gameList", gameList);
		return model;
	}
	
	@RequestMapping("/addGame")
	public String addGamePage(ModelAndView model){
		return "/backend/game/gameAdd";
	}
	
	@RequestMapping("/doAddGame")
	public ModelAndView doAddGame(Game game){
		gameService.addGame(game);
		ModelAndView model = new ModelAndView("redirect:/backend/game/manage");
		return model;
	}
	
}
