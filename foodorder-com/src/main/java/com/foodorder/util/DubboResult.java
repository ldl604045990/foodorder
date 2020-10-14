package com.foodorder.util;

import com.foodorder.exception.BusinessServiceException;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

public class DubboResult<T> implements Serializable {

    /**
     * 请求正常，处理成功
     */
    public static int BUSI_CODE_200 = 200;

    /**
     * 请求失败，处理失败
     */
    public static int BUSI_CODE_500 = 500;

    /**
     * 请求超时
     */
    public static int BUSI_CODE_408 = 408;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 业务响应码
     */
    private int busiCode;

    /**
     * 提示内容
     */
    private String message;

    /**
     * 结果集
     */
    private T data;

    public DubboResult() {

    }

    public DubboResult(int busiCode, String message, T data) {
        this.timestamp = System.currentTimeMillis();
        this.busiCode = busiCode;
        this.message = message;
        this.data = data;
        //log.info("请求返回的结果为：" + toString());
    }

    public static <T> DubboResult<T> success(T data) {
        DubboResult<T> result = new DubboResult<>(BUSI_CODE_200, "成功.", data);
        return result;
    }

    public static <T> DubboResult<T> success(T data, String message) {
        DubboResult<T> result = new DubboResult<>(BUSI_CODE_200, message, data);
        return result;
    }

    public static <T> DubboResult<T> error(String message) {
        DubboResult<T> result = new DubboResult<>(BUSI_CODE_500, message, null);
        return result;
    }

    public static <T> DubboResult<T> error(int Code, String message) {
        DubboResult<T> result = new DubboResult<>(Code, message, null);
        return result;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(int busiCode) {
        this.busiCode = busiCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        if (this.busiCode == BUSI_CODE_500) {
            throw BusinessServiceException.throwMsgException(StringUtils.isEmpty(message) ? "dubbo返回业务失败,结果集无法获取." :message);
        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DubboResult [timestamp=" + timestamp + ", busiCode=" + busiCode + ", message=" + message + ", data=" + data + "]";
    }

}
