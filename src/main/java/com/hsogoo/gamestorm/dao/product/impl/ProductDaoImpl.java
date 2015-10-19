package com.hsogoo.gamestorm.dao.product.impl;

import java.util.List;

import com.hsogoo.gamestorm.vo.ProductLevelConfig;
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

	public List<ProductType> getAllProductTypeList() {
		return this.getSqlMapClientTemplate().queryForList("gs_product_type.getAllProductTypeList");
	}

	public List<ProductType> getProductTypeForCheck(ProductType productType) {
		return this.getSqlMapClientTemplate().queryForList("gs_product_type.getProductTypeForCheck", productType);
	}

	public void addProductType(ProductType productType) {
		this.getSqlMapClientTemplate().insert("gs_product_type.addProductType", productType);
	}

	public List<AttrType> getAllAttrTypeList() {
		return this.getSqlMapClientTemplate().queryForList("gs_attr_type.getAllAttrTypeList");
	}

	public List<AttrValue> getAllAttrValueList() {
		return this.getSqlMapClientTemplate().queryForList("gs_attr_value.getAllAttrValueList");
	}

	public void addAttrType(AttrType attrType) {
		this.getSqlMapClientTemplate().insert("gs_attr_type.addAttrType", attrType);
	}

	public void addAttrValue(AttrValue attrValue) {
		this.getSqlMapClientTemplate().insert("gs_attr_type.addAttrValue", attrValue);
	}

	public List<ProductLevelConfig> getAllProductLevelConfig(){
		return this.getSqlMapClientTemplate().queryForList("gs_level_config.getAllLevelConfigList");
	}

	public void insertLevelConfig(ProductLevelConfig productLevelConfig) {
		this.getSqlMapClientTemplate().insert("gs_level_config.insertLevelConfig", productLevelConfig);
	}

	@Override
	public List<AttrValue> getAttrValueListById(Long attrTypeId) {
		return this.getSqlMapClientTemplate().queryForList("gs_attr_value.getAttrValueListById", attrTypeId);
	}
}
