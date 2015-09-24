package com.hsogoo.gamestorm.dao.gameCategory;

import com.hsogoo.gamestorm.vo.Category;
import com.hsogoo.gamestorm.vo.Game;


/**
 * Created by weile on 15/9/24.
 */
public interface GameCategoryDao {

    /**
     * 查找已经存在且有效该分类集合的游戏
     * @param gameId
     * @return
     */
    public Game findExsitCategorysByGameId(Long gameId);

    /**
     * 查找已经存在且有效游戏结合的分类
     * @param categoryId
     * @return
     */
    public Category findExsitGamesByCategoryId(Long categoryId);

    /**
     * 新增游戏和分类对应关系数据
     * @param gameId
     * @param categoryId
     * @return
     */
    int insertGameAndCategoryRelation(Long gameId,Long categoryId);

    /**
     * 更新游戏和分类对应关系数据
     * @param gameId
     * @param categoryId
     * @return
     */
    int updateGameAndCategoryRelation(Long gameId,Long categoryId);
}
