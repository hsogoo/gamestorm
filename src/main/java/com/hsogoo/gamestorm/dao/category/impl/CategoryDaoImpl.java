package com.hsogoo.gamestorm.dao.category.impl;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.category.CategoryDao;
import com.hsogoo.gamestorm.vo.Category;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weile on 15/9/21.
 */
@Repository
public class CategoryDaoImpl extends BaseDao implements CategoryDao{

    public List<Category> getAllCategoryList() {
        return this.getSqlMapClientTemplate().queryForList("gs_category.getAllCategoryList");
    }

    public void insert(Category category) {
        this.getSqlMapClientTemplate().insert("gs_category.insertCategory",category);
    }

    public int update(Category category) {
        return this.getSqlMapClientTemplate().update("gs_category.updateCategory",category);
    }

    public Category get(Long id) {
        return (Category) getSqlMapClientTemplate().queryForObject("gs_category.getCategory", id);
    }

    public List<Category> findFuzzyCategorys(String categoryId,String categoryName){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",categoryId);
        map.put("categoryName",categoryName);
        return this.getSqlMapClientTemplate().queryForList("gs_category.findFuzzyCategorys",map);
    }
}
