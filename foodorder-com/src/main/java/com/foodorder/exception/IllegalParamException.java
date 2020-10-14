package com.foodorder.exception;

/**
 * 参数非法，参数校验失败都使用该异常
 */
public class IllegalParamException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private IllegalParamException(String msg) {
		super(msg);
	}

	public static IllegalParamException throwMsgException(String msg) {
		return new IllegalParamException(msg);
	}
}
