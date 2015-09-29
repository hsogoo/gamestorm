package com.hsogoo.gamestorm.vo;

import java.io.Serializable;

/**
 * Created by weile on 15/9/29.
 */
public class GameServer implements Serializable {

    private static final long serialVersionUID = 1995527580685267907L;

    private Long id;

    private String serverName;

    private Long gameId;

    private String gameName;

    private Boolean status = true;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
