package com.hsogoo.gamestorm.service.gameServer.impl;

import com.hsogoo.gamestorm.dao.game.GameDao;
import com.hsogoo.gamestorm.dao.gameServer.GameServerDao;
import com.hsogoo.gamestorm.service.gameServer.GameServerService;
import com.hsogoo.gamestorm.vo.Game;
import com.hsogoo.gamestorm.vo.GameServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by weile on 15/9/29.
 */
@Service
public class GameServerServiceImpl implements GameServerService {

    @Autowired
    private GameDao gameDao;

    @Autowired
    private GameServerDao gameServerDao;

    public List<GameServer> getAllGameServerList() {
        //查询对应的游戏服务器列表
        List<GameServer> gameServers =  gameServerDao.getAllGameServerList();

        //设置服务器对应游戏名称
//        for (Iterator<GameServer> iterator = gameServers.iterator(); iterator.hasNext(); ) {
//            GameServer gameServer =  iterator.next();
//            if(gameServer.getGameId() != null){
//                Game game = gameDao.getGameById(gameServer.getGameId());
//                if(game == null){
//                    gameServer.setGameName(game.getGameName());
//                }
//            }
//        }

        return gameServers;
    }

    public int addGameServer(GameServer gameServer) {
        gameServerDao.insert(gameServer);
        return 1;
    }

    public int updateGameServer(GameServer gameServer) {
        return gameServerDao.update(gameServer);
    }

	@Override
	public void addGameServerList(List<GameServer> gameServerList) {
		gameServerDao.addGameServerList(gameServerList);
	}

	@Override
	public void deleteGameServerById(Long id) {
		gameServerDao.deleteGameServerById(id);
	}
}
