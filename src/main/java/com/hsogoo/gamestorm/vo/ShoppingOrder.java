package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author huangsaigang
 * @time 15-12-29 下午1:48
 */
public class ShoppingOrder implements Serializable {

    private Long orderId;
    private String orderCode;
    private ShoppingCart shoppingCart;
    private PaymentInfo paymentInfo;
    private ShoppingInfo shoppingInfo;
    private BigDecimal orderAmount;
}
