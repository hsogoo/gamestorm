package com.hsogoo.gamestorm.dao.shopping;

import com.hsogoo.gamestorm.vo.ShoppingCart;

/**
 * @author huangsaigang
 * @time 15-12-30 上午11:25
 */
public interface ShoppingDao {

    public void updateUserCart(ShoppingCart mergedCart);

    public void clearUserCart(Long userId);

}
