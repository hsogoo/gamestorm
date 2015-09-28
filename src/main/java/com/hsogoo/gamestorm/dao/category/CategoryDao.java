package com.hsogoo.gamestorm.dao.category;

import com.hsogoo.gamestorm.vo.Category;


import java.util.List;

/**
 * Created by weile on 15/9/21.
 */
public interface CategoryDao {

    /**
     * 查询游戏分类集合（不带游戏明细）
     * @return
     */
    List<Category> getAllCategoryList();

    /**
     * 新增插入分类信息
     * @param category
     * @return
     */
    void insert(Category category);

    /**
     * 更新修改分类信息
     * @param category
     * @return
     */
    int update(Category category);

    /**
     * 获取分类信息明细 by 分类id
     * @param id
     * @return
     */
    Category get(Long id);

    /**
     * 根据分类名称和id模糊查询分类信息
     * @param categoryId
     * @param categoryName
     * @return
     */
    public List<Category> findFuzzyCategorys(Long categoryId,String categoryName);
}
