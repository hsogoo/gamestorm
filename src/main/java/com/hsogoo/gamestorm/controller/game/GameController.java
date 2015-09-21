package com.hsogoo.gamestorm.controller.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hsogoo
 * @time 2015-9-21 下午10:40:32
 * @description
 */
@Controller
@RequestMapping("/backend/game")
public class GameController {
	
	@RequestMapping("/")
	public String getGamePage(Model model){
		return "backend/gameManager";
	}
	
	@RequestMapping("/gameList")
	@ResponseBody
	public ModelAndView getGameList(ModelAndView model){
		List<Game> gameList = gameService.getAllGameList();
		model.setViewName("backend/game/gameList");
		return model;
	}
	
}
