package com.hsogoo.gamestorm.vo;

/**
 * @author hsogoo
 * @time 2015-10-7 上午11:03:56
 * @description
 */
public class ContentType {

	private Long id;
	private String typeName;
	private Boolean status = true;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
