package com.hsogoo.gamestorm.service.gameServer;

import com.hsogoo.gamestorm.vo.GameServer;

import java.util.List;

/**
 * Created by weile on 15/9/29.
 */
public interface GameServerService {

    public List<GameServer> getAllGameServerList();

    public int addGameServer(GameServer gameServer);

    public int updateGameServer(GameServer gameServer);

    public void addGameServerList(List<GameServer> gameServerList);

	public void deleteGameServerById(Long id);
}
