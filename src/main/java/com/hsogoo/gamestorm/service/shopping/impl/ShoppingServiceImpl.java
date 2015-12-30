package com.hsogoo.gamestorm.service.shopping.impl;

import com.hsogoo.gamestorm.constant.NormalConstant;
import com.hsogoo.gamestorm.dao.shopping.ShoppingDao;
import com.hsogoo.gamestorm.service.shopping.ShoppingService;
import com.hsogoo.gamestorm.util.SessionUtil;
import com.hsogoo.gamestorm.vo.CartItem;
import com.hsogoo.gamestorm.vo.ShoppingCart;
import com.hsogoo.gamestorm.vo.ShoppingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangsaigang
 * @time 15-12-29 下午1:42
 */
@Service
public class ShoppingServiceImpl implements ShoppingService{

    @Autowired
    private ShoppingDao shoppingDao;

    public ShoppingCart showCart() {
        /**获取sessionCart*/
        ShoppingCart sessionCart = SessionUtil.get(NormalConstant.SESSION_CART_KEY,ShoppingCart.class);
        if(SessionUtil.getUserId() != null){
            ShoppingCart userCart = restoreShoppingCartFromDB(SessionUtil.getUserId());
            if(userCart != null){
                //如果userCart不为空，则合并userCart和sessionCart
                return mergeCart(sessionCart, userCart);
            }
        }
        return sessionCart;
    }

    private ShoppingCart restoreShoppingCartFromDB(Long userId) {
        return null;
    }

    public ShoppingCart addToCart(List<CartItem> cartItems) {
        return null;
    }

    public ShoppingCart updateCart(List<CartItem> cartItems) {
        return null;
    }

    public ShoppingOrder createOrder(ShoppingCart cart) {
        return null;
    }

    /**刷新购物车*/
    private ShoppingCart refreshCart(){
        return null;
    }

    /**合并sessionCart和userCart*/
    private ShoppingCart mergeCart(ShoppingCart sessionCart, ShoppingCart userCart){
        ShoppingCart mergedCart = null;
        if(mergedCart != null){
            shoppingDao.updateUserCart(mergedCart);
        }
        return mergedCart;
    }

    public void clearCart(Long userId){
        //清空sessionCart
        SessionUtil.set(NormalConstant.SESSION_CART_KEY, null);
        //清空userCart
        if(userId != null){
            shoppingDao.clearUserCart(userId);
        }
    }

}
