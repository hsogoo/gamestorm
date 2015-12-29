package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author huangsaigang
 * @time 下午1:26
 */
public class ShoppingCart implements Serializable {

    private List<CartItem> cartItemList;
    private BigDecimal totalAmount;
    private int totalCount;

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
