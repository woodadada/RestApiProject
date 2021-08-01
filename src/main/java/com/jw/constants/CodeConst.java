package com.jw.constants;

/**
 * 코드
 * @author wjddn
 *
 */
public enum CodeConst {
	
	/**삭제 여부*/
	BOOLEAN_TRUE("Y"),
	/**삭제 여부*/
	BOOLEAN_FALSE("N"),

	/**제품 타입 채소*/
	PRODUCT_TYPE_VEGETABLE("vegetable"),
	/**제품 타입 과일*/
	PRODUCT_TYPE_FRUIT("fruit");
	
	private String value;
	
	CodeConst(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return this.getValue();
	}
}
