package com.bs.tools;

/**
 * message helper
 * @author Administrator
 *
 */
public enum IntegerEnumType {
	
	NO_STOCK(400),
	ZERO_STOCK(500),
	NO_LOGIN(300);
 
    private int value;
    private IntegerEnumType(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
