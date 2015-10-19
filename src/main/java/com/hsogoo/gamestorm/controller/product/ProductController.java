package com.hsogoo.gamestorm.controller.product;

import java.util.List;

import com.hsogoo.gamestorm.vo.*;
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
	public ModelAndView getAttrType(ModelAndView model){
		List<AttrType> attrTypeList = productService.getAllAttrTypeList();
		model.setViewName("/backend/product/attrType");
		model.addObject("attrTypeList", attrTypeList);
		return model;
	}

	@RequestMapping("/addAttrType")
	public ModelAndView addAttrType(AttrType attrType){
		productService.addAttrType(attrType);
		ModelAndView model = new ModelAndView("redirect:/backend/product/attrType");
		return model;
	}

	
	@RequestMapping("/attrValue")
	public ModelAndView getProductAttrValue(ModelAndView model){
		List<AttrValue> attrValueList = productService.getAllAttrValueList();
		List<AttrType> attrTypeList = productService.getAllAttrTypeList();
		model.setViewName("/backend/product/attrValue");
		model.addObject("attrValueList", attrValueList);
		model.addObject("attrTypeList", attrTypeList);
		return model;
	}

	@RequestMapping("/addAttrValue")
	public ModelAndView addAttrValue(AttrValue attrValue){
		productService.addAttrValue(attrValue);
		ModelAndView model = new ModelAndView("redirect:/backend/product/attrValue");
		return model;
	}
	
	@RequestMapping("/levelPrice")
	public ModelAndView getLevelPrice(ModelAndView model){
		List<ProductLevelConfig> productLevelConfigList = productService.getAllProductLevelConfig();
		model.setViewName("/backend/product/levelPrice");
		model.addObject("productLevelConfigList", productLevelConfigList);
		return model;
	}
	
	@RequestMapping("/doAddLevelPrices")
	public ModelAndView doAddLevelPrices(ProductLevelConfig productLevelConfig){
		productService.addLevelConfig(productLevelConfig);
		ModelAndView model = new ModelAndView("redirect:/backend/product/levelPrice");
		return model;
	}

	@RequestMapping("/addLevelPrice")
	public ModelAndView addLevelPrice(ModelAndView model){
		List<Game> gameList = gameService.getAllGameList();
		model.addObject("gameList", gameList);
		model.setViewName("/backend/product/addLevelPrice");
		return model;
	}
	
	@RequestMapping("/addProductPage")
	public ModelAndView addProductPage(ModelAndView model){
		model.setViewName("/backend/product/addProduct");
		List<Game> gameList = gameService.getAllGameList();
		List<Category> categoryList = categoryService.getAllCategoryList();
		List<ProductType> productTypeList = productService.getAllProductTypeList();
		model.addObject("productTypeList", productTypeList);
		model.addObject("gameList", gameList);
		model.addObject("categoryList", categoryList);
		return model;
	}


}
