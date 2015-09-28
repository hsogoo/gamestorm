package com.hsogoo.gamestorm.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.product.ProductService;
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
	
	@RequestMapping("/manage")
	public ModelAndView getGamePage(ModelAndView model){
		List<Product> productList = productService.getAllProductList();
		model.setViewName("/backend/product/productManager");
		model.addObject("productList", productList);
		return model;
	}
}
