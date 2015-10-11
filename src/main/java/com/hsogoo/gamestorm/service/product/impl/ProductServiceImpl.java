package com.hsogoo.gamestorm.service.product.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsogoo.gamestorm.dao.product.ProductDao;
import com.hsogoo.gamestorm.service.product.ProductService;
import com.hsogoo.gamestorm.vo.AttrType;
import com.hsogoo.gamestorm.vo.AttrValue;
import com.hsogoo.gamestorm.vo.Product;
import com.hsogoo.gamestorm.vo.ProductType;

/**
 * @author hsogoo
 * @time 2015-9-27 下午09:22:27
 * @description
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> getAllProductList() {
		return null;
	}

	@Override
	public List<ProductType> getAllProductTypeList() {
		return productDao.getAllProductTypeList();
	}

	@Override
	public List<ProductType> getProductTypeForCheck(ProductType productType) {
		return productDao.getProductTypeForCheck(productType);
	}

	@Override
	public void addProductType(ProductType productType) {
		productDao.addProductType(productType);
	}

	@Override
	public List<AttrType> getAllAttrTypeList() {
		return productDao.getAllAttrTypeList();
	}

	@Override
	public List<AttrValue> getAllAttrValueList() {
		return productDao.getAllAttrValueList();
	}

}
