package com.bs.tools;

/**
 * 消息帮组类
 * 
 * @author Administrator
 *
 */
public class MsgHelper {
	private int code;
	private String message;
	private String url;

	public MsgHelper() {
		this.code = 200;
		this.message = "操作成功";
	}

	public MsgHelper(boolean flag) {
		if (flag) {
			this.code = 200;
			this.message = "操作成功";
		} else {
			this.code = -200;
			this.message = "操作失败";
		}
	}

	public MsgHelper(String message) {
		this.code = 200;
		this.message = message;
	}

	public MsgHelper(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public MsgHelper(int code, String message, String url) {
		this(code,message);
		this.url = url;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
