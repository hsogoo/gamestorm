package com.hsogoo.gamestorm.vo;

import java.util.List;

/**
 * @author hsogoo
 * @time 2015-10-11 下午12:53:26
 * @description
 */
public class ProductTypeAttr {

	private Long id;
	private Long productTypeId;
	private List<AttrType> attrTypeList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}

	public List<AttrType> getAttrTypeList() {
		return attrTypeList;
	}

	public void setAttrTypeList(List<AttrType> attrTypeList) {
		this.attrTypeList = attrTypeList;
	}

}
