package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author huangsaigang
 * @time 15-12-29 下午1:51
 */
public class PaymentInfo implements Serializable{

    /**支持的支付方式*/
    private List<PaymentMethod> supportPaymentMethodList;
    /**选择的支付方式**/
    private PaymentMethod selectedPaymentMethod;

    public List<PaymentMethod> getSupportPaymentMethodList() {
        return supportPaymentMethodList;
    }

    public void setSupportPaymentMethodList(List<PaymentMethod> supportPaymentMethodList) {
        this.supportPaymentMethodList = supportPaymentMethodList;
    }

    public PaymentMethod getSelectedPaymentMethod() {
        return selectedPaymentMethod;
    }

    public void setSelectedPaymentMethod(PaymentMethod selectedPaymentMethod) {
        this.selectedPaymentMethod = selectedPaymentMethod;
    }
}
