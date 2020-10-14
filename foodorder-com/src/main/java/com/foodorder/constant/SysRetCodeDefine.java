package com.foodorder.constant;

/**
 * 系统常量配置枚举类
 */
public enum SysRetCodeDefine {

	/** 系统内部错误 */
	SYS_PROCESS_INNER_ERROR("EYYY01", "系统内部错误"),

	/** 系统处理成功 */
	SYS_PROCCESS_SUCCESS("000000", "系统处理成功"),

	/** 重复的请求 */
	SYS_PROCCESS_REPEAT("000701", "重复的请求"),

	/** 业务受理中 **/
	SYS_PROCESS_ING("000704", "业务受理中"),

	/** 记录不存在 **/
	SYS_RECORD_NOEXIST("000705", "记录不存在"),

	/** 系统处理失败 */
	SYS_PROCCESS_FAILED("999999", "系统处理失败"),

	/** 用户强制性需要修改Code密码 */
	USER_NEED_UPDATE_PWD("999988", "密码强制修改"),
	
	/**未绑定*/
	USER_NO_BIND("999987","未绑定");

	private String key;

	private String value;

	private SysRetCodeDefine(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getKey() {
		return key;
	}
}
