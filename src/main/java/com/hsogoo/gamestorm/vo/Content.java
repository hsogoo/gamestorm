package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hsogoo
 * @time 2015-10-7 上午10:32:44
 * @description
 */
public class Content implements Serializable {

	private static final long serialVersionUID = 8736155376891064808L;
	/** 这里简单点不弄枚举了 */
	private Integer type;
	private String title;
	private String content;
	private Integer status;
	private Date createTime;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
