package com.hsogoo.gamestorm.dao.gameCategory;

import java.util.List;


/**
 * Created by weile on 15/9/24.
 */
public interface GameCategoryDao {

    /**
     * 查找已经存在且有效该分类id集合
     * @param gameId
     * @return
     */
    public List<Long> findExsitCategoryIdsByGameId(Long gameId);

    /**
     * 查找已经存在且有效游戏id集合
     * @param categoryId
     * @return
     */
    public List<Long> findExsitGameIdsByCategoryId(Long categoryId);

    /**
     * 新增游戏和分类对应关系数据
     * @param gameId
     * @param categoryId
     * @return
     */
    void insertGameAndCategoryRelation(Long gameId,Long categoryId);

    /**
     * 更新游戏和分类对应关系数据
     * @param id 关联关系id
     * @param gameId 游戏id
     * @param categoryId 分类id
     * @param status 状态
     * @return
     */
    int updateGameAndCategoryRelation(Long id,Long gameId, Long categoryId,Boolean status);
}
