package com.hsogoo.gamestorm.service.shopping;

import com.hsogoo.gamestorm.vo.CartItem;
import com.hsogoo.gamestorm.vo.ShoppingCart;
import com.hsogoo.gamestorm.vo.ShoppingOrder;

/**
 * @author huangsaigang
 * @time 15-12-29 下午1:41
 */
public interface ShoppingService {

    public ShoppingCart showCart();

    public ShoppingCart addToCart(CartItem cartItem);

    public ShoppingCart updateCart(CartItem cartItem);

    public ShoppingOrder createOrder(ShoppingCart cart);

}
