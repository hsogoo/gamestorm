package com.hsogoo.gamestorm.dao.gameServer.impl;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.gameServer.GameServerDao;
import com.hsogoo.gamestorm.vo.GameServer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by weile on 15/9/29.
 */
@Repository
public class GameServerDaoImpl extends BaseDao implements GameServerDao {

    public List<GameServer> getAllGameServerList() {
        return this.getSqlMapClientTemplate().queryForList("gs_game_server.getAllGameServerList");
    }

    public void insert(GameServer gameServer) {
        this.getSqlMapClientTemplate().insert("gs_game_server.insertGameServer",gameServer);
    }

    public int update(GameServer gameServer) {
        return this.getSqlMapClientTemplate().update("gs_game_server.updateGameServer", gameServer);
    }

}
