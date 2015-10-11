package com.hsogoo.gamestorm.dao.product.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.product.ProductDao;
import com.hsogoo.gamestorm.vo.AttrType;
import com.hsogoo.gamestorm.vo.AttrValue;
import com.hsogoo.gamestorm.vo.ProductType;

/**
 * @author hsogoo
 * @time 2015-10-11 下午01:17:22
 * @description
 */
@Repository
public class ProductDaoImpl extends BaseDao implements ProductDao{

	@Override
	public List<ProductType> getAllProductTypeList() {
		return this.getSqlMapClientTemplate().queryForList("gs_product_type.getAllProductTypeList");
	}

	@Override
	public List<ProductType> getProductTypeForCheck(ProductType productType) {
		return this.getSqlMapClientTemplate().queryForList("gs_product_type.getProductTypeForCheck", productType);
	}

	@Override
	public void addProductType(ProductType productType) {
		this.getSqlMapClientTemplate().insert("gs_product_type.addProductType", productType);
	}

	@Override
	public List<AttrType> getAllAttrTypeList() {
		return this.getSqlMapClientTemplate().queryForList("gs_attr_type.getAllAttrTypeList");
	}

	@Override
	public List<AttrValue> getAllAttrValueList() {
		return this.getSqlMapClientTemplate().queryForList("gs_attr_value.getAllAttrValueList");
	}

}
