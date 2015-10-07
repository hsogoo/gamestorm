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
	private Long id;
	private Integer typeId;
	private String typeName;
	private String title;
	private String content;
	private Boolean status = true;
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
