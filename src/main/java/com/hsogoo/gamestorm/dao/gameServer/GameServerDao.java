package com.hsogoo.gamestorm.dao.gameServer;

import com.hsogoo.gamestorm.vo.GameServer;

import java.util.List;

/**
 * Created by weile on 15/9/29.
 */
public interface GameServerDao {

    public List<GameServer> getAllGameServerList();

    public void insert(GameServer gameServer);

    public int update(GameServer gameServer);

    public void addGameServerList(List<GameServer> gameServerList);

	public void deleteGameServerById(Long id);
}
