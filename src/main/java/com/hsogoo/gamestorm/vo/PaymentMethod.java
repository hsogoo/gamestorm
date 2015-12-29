package com.hsogoo.gamestorm.vo;

/**
 * @author huangsaigang
 * @time 15-12-29 下午2:02
 */
public class PaymentMethod {

    private Long id;
    private String paymentName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
