package com.foodorder.util;

import com.foodorder.constant.SysRetCodeDefine;

import java.io.Serializable;

public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * code 定义参考SysConstantsEnum
     */
    public String code;

    public String message;

    /**
     * 用户业务类快速判断，不用取操作码进行equals判断 结果返回000000时为true，其他情况为false
     */
    private boolean opResult;

    /**
     * 名字修改为repData，避免页面取值时data.data区分不清，现在取值data.repData
     */
    private T repData;

    public ResultBean(String code, String message, boolean opResult, T data) {
        this.code = code;
        this.message = message;
        this.opResult = opResult;
        this.repData = data;
        // 规避结果集是String类型时无法赋值的问题
        if (repData != null && data instanceof String) {
            this.message = (String) data;
        }
    }

    public ResultBean() {

    }

    public static <T> ResultBean<T> success(String message, T data) {
        return new ResultBean<>(SysRetCodeDefine.SYS_PROCCESS_SUCCESS.getKey(), message, true, data);
    }

    public static <T> ResultBean<T> success(T data) {
        return new ResultBean<>(SysRetCodeDefine.SYS_PROCCESS_SUCCESS.getKey(), null, true, data);
    }

    public static <T> ResultBean<T> error(String message) {
        return new ResultBean<>(SysRetCodeDefine.SYS_PROCCESS_FAILED.getKey(), message, false, null);
    }

    public static <T> ResultBean<T> error(String code, String message) {
        return new ResultBean<>(code, message, false, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String returnCode) {
        this.code = returnCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getRepData() {
        return repData;
    }

    public void setRepData(T repData) {
        this.repData = repData;
    }

    public boolean isOpResult() {
        return opResult;
    }

    public void setOpResult(boolean opResult) {
        this.opResult = opResult;
    }

    @Override
    public String toString() {
        return "RpcResult [code=" + code + ", message=" + message + ", opResult=" + opResult + ", repData=" + repData + "]";
    }

}
