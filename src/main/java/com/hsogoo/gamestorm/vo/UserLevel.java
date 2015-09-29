package com.hsogoo.gamestorm.vo;

import java.util.Date;

/**
 * @author hsogoo
 * @time 2015-9-13 下午02:10:27
 * @description
 */
public class UserLevel {

	private Long id;
	private BigDecimal levelName;
	private String orderAmount;
	private BigDecimal levelDiscount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getLevelDiscount() {
		return levelDiscount;
	}

	public void setLevelDiscount(BigDecimal levelDiscount) {
		this.levelDiscount = levelDiscount;
	}

}
