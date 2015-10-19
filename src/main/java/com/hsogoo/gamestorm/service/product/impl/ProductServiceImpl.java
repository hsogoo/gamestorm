package com.hsogoo.gamestorm.service.product.impl;

import java.util.List;

import com.hsogoo.gamestorm.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsogoo.gamestorm.dao.product.ProductDao;
import com.hsogoo.gamestorm.service.product.ProductService;

/**
 * @author hsogoo
 * @time 2015-9-27 下午09:22:27
 * @description
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAllProductList() {
		return null;
	}

	public List<ProductType> getAllProductTypeList() {
		return productDao.getAllProductTypeList();
	}

	public List<ProductType> getProductTypeForCheck(ProductType productType) {
		return productDao.getProductTypeForCheck(productType);
	}

	public void addProductType(ProductType productType) {
		productDao.addProductType(productType);
	}

	public List<AttrType> getAllAttrTypeList() {
		return productDao.getAllAttrTypeList();
	}

	public List<AttrValue> getAllAttrValueList() {
		return productDao.getAllAttrValueList();
	}

	public void addAttrType(AttrType attrType) {
		productDao.addAttrType(attrType);
	}

	public void addAttrValue(AttrValue attrValue){
		productDao.addAttrValue(attrValue);
	}

	public List<ProductLevelConfig> getAllProductLevelConfig() {
		return productDao.getAllProductLevelConfig();
	}

	public void addLevelConfig(ProductLevelConfig productLevelConfig){
		productDao.insertLevelConfig(productLevelConfig);
	}

	@Override
	public List<AttrValue> getAttrValueListById(Long attrTypeId) {
		return productDao.getAttrValueListById(attrTypeId);
	}


}
