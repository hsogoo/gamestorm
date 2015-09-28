package com.hsogoo.gamestorm.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hsogoo.gamestorm.service.category.CategoryService;
import com.hsogoo.gamestorm.vo.Category;

/**
 * Created by weile on 15/9/21.
 */

@Controller
@RequestMapping("/backend/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/manage")
    public ModelAndView getCategoryPage(ModelAndView model){
        List<Category> categoryList = categoryService.getAllCategoryList();
        model.setViewName("/backend/category/categoryManager");
        model.addObject("categoryList", categoryList);
        return model;
    }

    @RequestMapping("/categoryList")
    @ResponseBody
    public ModelAndView getCategoryList(ModelAndView model,@RequestParam(value ="page") String page){
        List<Category> categoryList = categoryService.getAllCategoryList();
        model.setViewName("/backend/category/categoryList");
        model.addObject("currentPage", page);
        //TODO:分页查询
        model.addObject("totalPage", categoryList.size());
        model.addObject("categoryList", categoryList);
        return model;
    }

    @RequestMapping("/addCategory")
    public String addCategoryPage(ModelAndView model){
        return "/backend/category/categoryAdd";
    }

    @RequestMapping("/doAddCategory")
    public ModelAndView doAddCategory(Category category){
        categoryService.addCategory(category);
        ModelAndView model = new ModelAndView("redirect:/backend/category/manage");
        return model;
    }

    @RequestMapping("/doSaveCategory")
    public ModelAndView doSaveCategory(Category category){
        categoryService.updateCategory(category);
        ModelAndView model = new ModelAndView("redirect:/backend/category/manage");
        return model;
    }

}
