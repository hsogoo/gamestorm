package com.hsogoo.gamestorm.dao.category;

import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;

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
    int insert(Category category);

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
     * 根据游戏名称和id模糊查询分类信息
     * @param gameId
     * @param gameName
     * @return
     */
    public List<Category> findFuzzyGameByGameName(String gameId,String gameName);
}
