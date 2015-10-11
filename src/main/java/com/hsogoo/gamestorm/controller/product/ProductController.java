package com.hsogoo.gamestorm.controller.product;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.constant.ResultConstant;
import com.hsogoo.gamestorm.service.category.CategoryService;
import com.hsogoo.gamestorm.service.game.GameService;
import com.hsogoo.gamestorm.service.product.ProductService;
import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;
import com.hsogoo.gamestorm.vo.GameCategory;
import com.hsogoo.gamestorm.vo.JsonResult;
import com.hsogoo.gamestorm.vo.Product;
import com.hsogoo.gamestorm.vo.ProductType;

/**
 * @author hsogoo
 * @time 2015-9-27 下午09:17:30
 * @description
 */
@Controller
@RequestMapping("/backend/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private GameService gameService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/manage")
	public ModelAndView getProductPage(ModelAndView model){
		List<Product> productList = productService.getAllProductList();
		model.setViewName("/backend/product/productManager");
		model.addObject("productList", productList);
		return model;
	}
	
	@RequestMapping("/type")
	public ModelAndView getProductType(ModelAndView model){
		List<ProductType> productTypeList = productService.getAllProductTypeList();
		List<Game> gameList = gameService.getAllGameList();
		List<Category> categoryList = categoryService.getAllCategoryList();
		model.setViewName("/backend/product/productType");
		model.addObject("productTypeList", productTypeList);
		model.addObject("gameList", gameList);
		model.addObject("categoryList", categoryList);
		return model;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addProductType")
	@ResponseBody
	public JsonResult addProductType(ProductType productType){
		JsonResult jsonResult = new JsonResult();
		List<ProductType> oldProductTypeList = productService.getProductTypeForCheck(productType);
		if(CollectionUtils.isNotEmpty(oldProductTypeList)){
			jsonResult.setCode(ResultConstant.ERROR_EXIST_CODE);
			jsonResult.setMessage(ResultConstant.ERROR_EXIST_MSG);
			return jsonResult;
		}
		productService.addProductType(productType);
		jsonResult.setCode(ResultConstant.SUCCESS);
		return jsonResult;
	}
	
	@RequestMapping("/attrType")
	public ModelAndView getProductAttrType(ModelAndView model){
		List<Product> productList = productService.getAllProductList();
		model.setViewName("/backend/product/productManager");
		model.addObject("productList", productList);
		return model;
	}
	
	@RequestMapping("/attrValue")
	public ModelAndView getProductAttrValue(ModelAndView model){
		List<Product> productList = productService.getAllProductList();
		model.setViewName("/backend/product/productManager");
		model.addObject("productList", productList);
		return model;
	}
	

}
