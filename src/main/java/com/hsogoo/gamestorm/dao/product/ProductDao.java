package com.hsogoo.gamestorm.dao.product;

import java.util.List;

import com.hsogoo.gamestorm.vo.ProductType;

/**
 * @author hsogoo
 * @time 2015-10-11 下午01:17:02
 * @description
 */
public interface ProductDao {

	public List<ProductType> getAllProductTypeList();

	public List<ProductType> getProductTypeForCheck(ProductType productType);

	public void addProductType(ProductType productType);
	
}
