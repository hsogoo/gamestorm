package com.hsogoo.gamestorm.service.category;

import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;

import java.util.List;

/**
 * Created by weile on 15/9/21.
 */
public interface CategoryService {

    /**
     * 查询游戏分类的列表集合信息（不带游戏明细）
     * @return
     */
    List<Category> getAllCategoryList();

}