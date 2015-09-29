package com.hsogoo.gamestorm.service.gameServer;

import com.hsogoo.gamestorm.vo.GameServer;

import java.util.List;

/**
 * Created by weile on 15/9/29.
 */
public interface GameServerService {

    List<GameServer> getAllGameServerList();

    int addGameServer(GameServer gameServer);

    int updateGameServer(GameServer gameServer);
}
