package com.foodorder.inter.user.web;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.util.DubboResult;
import com.foodorder.inter.user.bean.OrderUser;
import com.foodorder.util.PagedResult;

/**
 * 用户
 * @author ldl
 * @date 2020-08-07
 */
public interface IDuOrderUser {

    /**
     * 登录
     * @param userName
     * @param userPwd
     * @return
     */
    DubboResult<OrderUser> login(String userName, String userPwd);

    /**
     * 注册
     * @param orderUser
     * @return
     */
    DubboResult<Boolean> register(JSONObject orderUser);

    /**
     *
     * @param jsonObject
     * @param pageSize
     * @param pageNo
     * @return
     */
    DubboResult<PagedResult<OrderUser>> orderUserList(JSONObject jsonObject,Integer pageSize,Integer pageNo);

    DubboResult<?> disableOrderUser(Integer userId);

    DubboResult<?> deleteOrderUser(Integer userId);

}
