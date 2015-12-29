package com.hsogoo.gamestorm.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author huangsaigang
 * @time 下午1:27
 * 购物车商品
 */
public class CartItem implements Serializable{

    private Long identifyId;
    private boolean checked;
    private String name;
    private String image;
    private Long productId;
    private BigDecimal price;
    private int count;
    private BigDecimal amount;
    private ProductType productType;
    private ProductMemo productMemo;

    public Long getIdentifyId() {
        return identifyId;
    }

    public void setIdentifyId(Long identifyId) {
        this.identifyId = identifyId;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductMemo getProductMemo() {
        return productMemo;
    }

    public void setProductMemo(ProductMemo productMemo) {
        this.productMemo = productMemo;
    }
}
