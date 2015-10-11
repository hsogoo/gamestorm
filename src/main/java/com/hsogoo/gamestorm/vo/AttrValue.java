package com.hsogoo.gamestorm.vo;

/**
 * @author hsogoo
 * @time 2015-10-11 下午12:51:01
 * @description
 */
public class AttrValue {

	private Long id;
	private Long typeId;
	private String typeName;
	private String attrValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

}
