package com.agile.model.enums;

public enum CouponNumbersEnum {

	COUPON_1("00000000000000000000"),
	COUPON_2("11111111111111111111"), 
	COUPON_3("22222222222222222222");

	private String description;

	CouponNumbersEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
