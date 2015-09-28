package com.hsogoo.gamestorm.vo;

import java.io.Serializable;

/**
 * @author hsogoo
 * @time 2015-9-27 下午08:12:19
 * @description
 */
public class GameCategory implements Serializable {

	private static final long serialVersionUID = -7077355922949134528L;
	private Long id;
	private String gameName;
	private Long gameId;
	private String categoryName;
	private Long categoryId;
	private Boolean status = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
