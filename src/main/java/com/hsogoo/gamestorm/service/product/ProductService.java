package com.hsogoo.gamestorm.service.product;

import java.util.List;

import com.hsogoo.gamestorm.vo.AttrType;
import com.hsogoo.gamestorm.vo.AttrValue;
import com.hsogoo.gamestorm.vo.Product;
import com.hsogoo.gamestorm.vo.ProductType;

/**
 * @author hsogoo
 * @time 2015-9-27 下午09:21:30
 * @description
 */
public interface ProductService {

	public List<Product> getAllProductList();
	
	public List<ProductType> getAllProductTypeList();

	public List<ProductType> getProductTypeForCheck(ProductType productType);

	public void addProductType(ProductType productType);

	public List<AttrType> getAllAttrTypeList();

	public List<AttrValue> getAllAttrValueList();

	public void addAttrType(AttrType attrType);

	public void addAttrValue(AttrValue attrValue);
}
