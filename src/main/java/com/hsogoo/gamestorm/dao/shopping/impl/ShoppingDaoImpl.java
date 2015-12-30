package com.hsogoo.gamestorm.dao.shopping.impl;

import com.hsogoo.gamestorm.dao.BaseDao;
import com.hsogoo.gamestorm.dao.shopping.ShoppingDao;
import com.hsogoo.gamestorm.vo.ShoppingCart;
import org.springframework.stereotype.Repository;

/**
 * @author huangsaigang
 * @time 15-12-30 上午11:26
 */
@Repository
public class ShoppingDaoImpl extends BaseDao implements ShoppingDao{

    public void updateUserCart(ShoppingCart mergedCart) {

    }

    public void clearUserCart(Long userId) {

    }
}
