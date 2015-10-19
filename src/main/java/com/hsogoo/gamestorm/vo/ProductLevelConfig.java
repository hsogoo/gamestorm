package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by weile on 15/10/18.
 */
public class ProductLevelConfig implements Serializable{

    private static final long serialVersionUID = -1803373722169735248L;

    private Long id;

    private Long gameId;

    private Integer startLevel;

    private Integer endLevel;

    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(Integer startLevel) {
        this.startLevel = startLevel;
    }

    public Integer getEndLevel() {
        return endLevel;
    }

    public void setEndLevel(Integer endLevel) {
        this.endLevel = endLevel;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
