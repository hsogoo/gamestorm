package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hsogoo
 * @time 2015-9-29 下午09:40:00
 * @description
 */
public class News implements Serializable {

	private static final long serialVersionUID = 9150650102408974362L;

	private Long id;
	private String newsTitle;
	private String newsContent;
	private Boolean status = true;
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
