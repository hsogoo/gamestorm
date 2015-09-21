package com.hsogoo.gamestorm.service.category.impl;

import com.hsogoo.gamestorm.dao.category.CategoryDao;
import com.hsogoo.gamestorm.service.category.CategoryService;
import com.hsogoo.gamestorm.vo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by weile on 15/9/21.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getAllCategoryList() {
        return categoryDao.getAllCategoryList();
    }

}
