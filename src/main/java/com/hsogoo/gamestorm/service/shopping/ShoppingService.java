package com.hsogoo.gamestorm.service.shopping;

import com.hsogoo.gamestorm.vo.CartItem;
import com.hsogoo.gamestorm.vo.ShoppingCart;
import com.hsogoo.gamestorm.vo.ShoppingOrder;

import java.util.List;

/**
 * @author huangsaigang
 * @time 15-12-29 下午1:41
 */
public interface ShoppingService {

    public ShoppingCart showCart();

    public ShoppingCart addToCart(List<CartItem> cartItems);

    public ShoppingCart updateCart(List<CartItem> cartItems);

    public ShoppingOrder createOrder(ShoppingCart cart);

}
