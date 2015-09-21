package com.hsogoo.gamestorm.controller.category;

import com.hsogoo.gamestorm.service.category.CategoryService;
import com.hsogoo.gamestorm.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by weile on 15/9/21.
 */

@Controller
@RequestMapping("/backend/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String getCategoryPage(Model model){
        return "backend/categoryManager";
    }

    @RequestMapping("/categoryList")
    @ResponseBody
    public ModelAndView getCategoryList(ModelAndView model){
        List<Category> categoryList = categoryService.getAllCategoryList();
        model.setViewName("backend/category/categoryList");
        return model;
    }
}
