package com.hsogoo.gamestorm.dao.gameServer;

import com.hsogoo.gamestorm.vo.GameServer;

import java.util.List;

/**
 * Created by weile on 15/9/29.
 */
public interface GameServerDao {

    List<GameServer> getAllGameServerList();

    void insert(GameServer gameServer);

    int update(GameServer gameServer);
}
