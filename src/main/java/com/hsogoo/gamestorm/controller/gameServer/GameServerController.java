package com.hsogoo.gamestorm.controller.gameServer;

import com.hsogoo.gamestorm.service.gameServer.GameServerService;
import com.hsogoo.gamestorm.vo.GameServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


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

    @RequestMapping("/manage")
    public ModelAndView getGameServerPage(ModelAndView model){
        model.setViewName("/backend/gameServer/gameServerManager");
        return model;
    }

    @RequestMapping("/gameServerList")
    @ResponseBody
    public ModelAndView getGameList(ModelAndView model,@RequestParam(value ="page") String page){
        List<GameServer> gameServerList = gameServerService.getAllGameServerList();
        model.setViewName("/backend/gameServer/gameServerList");
        //TODO:分页查询
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
        gameServerService.addGameServer(gameServer);
        ModelAndView model = new ModelAndView("redirect:/backend/gameServer/manage");
        return model;
    }

    @RequestMapping("/doSaveGameServer")
    public ModelAndView doSaveGameServer(GameServer gameServer){
        gameServerService.updateGameServer(gameServer);
        ModelAndView model = new ModelAndView("redirect:/backend/gameServer/manage");
        return model;
    }

	
}
