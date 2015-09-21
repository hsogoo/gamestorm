package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author hsogoo
 * @time 2015-9-21 下午10:59:45
 * @description
 */
public class Category implements Serializable {

	private static final long serialVersionUID = -1531763281002684072L;

	private Long id;
	private String categoryName;
	private Boolean status = true;
	private List<Game> gameList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Game> getGameList() {
		return gameList;
	}

	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}

}
