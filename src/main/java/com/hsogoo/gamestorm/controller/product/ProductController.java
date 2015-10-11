package com.hsogoo.gamestorm.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.category.CategoryService;
import com.hsogoo.gamestorm.service.game.GameService;
import com.hsogoo.gamestorm.service.product.ProductService;
import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;
import com.hsogoo.gamestorm.vo.GameCategory;
import com.hsogoo.gamestorm.vo.Product;

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
		List<Product> productList = productService.getAllProductList();
		List<Game> gameList = gameService.getAllGameList();
		List<Category> categoryList = categoryService.getAllCategoryList();
		model.setViewName("/backend/product/productType");
		model.addObject("productList", productList);
		model.addObject("gameList", gameList);
		model.addObject("categoryList", categoryList);
		return model;
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
