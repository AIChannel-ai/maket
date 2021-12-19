package com.bs.tools;

/**
 * t_common  type1
 * @author Administrator
 *
 */
public enum StringEnumType {
	
	ADDRESS("address"),
	NO_LOGIN_MSG("登录已超时，请重新登录"),
	NO_SEND("待发货"),
	SENDING("已发货"),
	SEND_DONE("已完成");
	
	private String value;
    private StringEnumType(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
