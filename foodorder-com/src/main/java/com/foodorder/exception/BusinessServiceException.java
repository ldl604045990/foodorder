package com.foodorder.exception;

/**
 * 业务类异常，dubbo调用异常等
 * 
 * service层异常，dubbo实现类异常都用此包装
 * 
 * 
 * 工具类参数校验等异常抛到service时直接取消息包装抛出 throwMsgException(String msg)
 * 
 * @author zhangyu
 * @date 2018年6月7日
 */
public class BusinessServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BusinessServiceException(String msg) {
		super(msg);
	}

	private BusinessServiceException(Throwable e) {
		super(e);
	}

	private BusinessServiceException(String msg, Throwable e) {
		super(msg, e);
	}

	public static BusinessServiceException throwMsgException(String msg) {
		return new BusinessServiceException(msg);
	}

	public static BusinessServiceException throwMsgException(String msg, Throwable e) {
		return new BusinessServiceException(msg, e);
	}

	public static BusinessServiceException throwMsgException(Throwable e) {
		return new BusinessServiceException(e);
	}
}
