package com.hsogoo.gamestorm.controller.gameServer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.game.GameService;
import com.hsogoo.gamestorm.service.gameServer.GameServerService;
import com.hsogoo.gamestorm.vo.Game;
import com.hsogoo.gamestorm.vo.GameServer;


/**
 * @author hsogoo
 * @time 2015-9-21 下午10:40:32
 * @description
 */
@Controller
@RequestMapping("/backend/gameServer")
public class GameServerController {

    @Autowired
    private GameServerService gameServerService;
    @Autowired
    private GameService gameService;
    
    private static final int MAX_LENGTH = 100;

    @RequestMapping("/manage")
    public ModelAndView getGameServerPage(ModelAndView model){
    	List<Game> gameList = gameService.getAllGameList();
    	List<GameServer> gameServerList = gameServerService.getAllGameServerList();
    	model.addObject("gameList",gameList);
    	model.addObject("gameServerList",gameServerList);
        model.setViewName("/backend/gameServer/gameServer");
        return model;
    }

    @RequestMapping("/gameServerList")
    @ResponseBody
    public ModelAndView getGameList(ModelAndView model,@RequestParam(value ="page") String page){
        List<GameServer> gameServerList = gameServerService.getAllGameServerList();
        model.setViewName("/backend/gameServer/gameServerList");
        model.addObject("currentPage", page);
        model.addObject("gameServerList", gameServerList);
        return model;
    }


    @RequestMapping("/addGameServer")
    public String addGameServerPage(ModelAndView model){
        return "/backend/gameServer/gameServerAdd";
    }

    @RequestMapping("/doAddGameServer")
    public ModelAndView doAddGameServer(GameServer gameServer){
    	ModelAndView model = new ModelAndView("redirect:/backend/gameServer/manage");
    	List<GameServer> gameServerList = new ArrayList<GameServer>();
    	String inputServerName = gameServer.getServerName();
    	if(StringUtils.isBlank(inputServerName)){
    		return model;
    	}else{
    		String[] gameServerStrArray = inputServerName.split(",");
    		if(gameServerStrArray.length < 1){
    			return model;
    		}else if(gameServerStrArray.length == 1){
    			if(inputServerName.length() > MAX_LENGTH){
    				return model;
    			}
    		}else{
    			for(int i = 0; i<gameServerStrArray.length; i++){
    				GameServer server = new GameServer();
    				server.setGameId(gameServer.getGameId());
    				server.setGameName(gameServer.getGameName());
    				server.setServerName(gameServerStrArray[i]);
    				gameServerList.add(server);
    			}
    			gameServerService.addGameServerList(gameServerList);
    		}
    	}
        return model;
    }

    @RequestMapping("/doSaveGameServer")
    public ModelAndView doSaveGameServer(GameServer gameServer){
        gameServerService.updateGameServer(gameServer);
        ModelAndView model = new ModelAndView("redirect:/backend/gameServer/manage");
        return model;
    }

    @RequestMapping("/deleteGameServer")
    public ModelAndView deleteGameServer(@RequestParam Long id){
        gameServerService.deleteGameServerById(id);
        ModelAndView model = new ModelAndView("redirect:/backend/gameServer/manage");
        return model;
    }
	
}
