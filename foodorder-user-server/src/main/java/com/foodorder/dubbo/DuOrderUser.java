package com.foodorder.dubbo;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.inter.user.dto.OrderShopDto;
import com.foodorder.service.inter.OrderUserService;
import com.foodorder.util.DubboResult;
import com.foodorder.inter.user.bean.OrderUser;
import com.foodorder.inter.user.web.IDuOrderUser;
import com.foodorder.util.PagedResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DuOrderUser implements IDuOrderUser {

    private static final Logger logger = LoggerFactory.getLogger(DuOrderUser.class);

    @Autowired
    private OrderUserService orderUserService;


    @Override
    public DubboResult<OrderUser> login(String userName, String userPwd) {
        try {
            OrderUser orderUser = orderUserService.login(userName,userPwd);
            return DubboResult.success(orderUser);
        } catch (Exception e){
            logger.error(" 登录异常 ："+e.getMessage());
            return DubboResult.error(" 登录异常："+e.getMessage());
        }
    }

    @Override
    public DubboResult<Boolean> register(JSONObject json) {
        try {
            Boolean isTrue = orderUserService.register(json);
            return DubboResult.success(isTrue);
        } catch (Exception e) {
            logger.error(" 注册商户异常 ："+e.getMessage());
            return DubboResult.error("注册商户异常："+e.getMessage());
        }
    }

    @Override
    public DubboResult<PagedResult<OrderUser>> orderUserList(JSONObject jsonObject, Integer pageSize, Integer pageNo) {
        try {
            PagedResult<OrderUser> pagedResult = orderUserService.getOrderUserList(jsonObject,pageNo,pageSize);
            return DubboResult.success(pagedResult);
        } catch (Exception e) {
            logger.error(" 获取用户列表异常 ："+e.getMessage());
            return DubboResult.error("获取用户列表异常："+e.getMessage());
        }
    }

    @Override
    public DubboResult<?> disableOrderUser(Integer userId) {
        try {
            Boolean result = orderUserService.disableOrderUser(userId);
            return DubboResult.success(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DubboResult.error(e.getMessage());
        }
    }

    @Override
    public DubboResult<?> deleteOrderUser(Integer userId) {
        try {
            Boolean result = orderUserService.deleteOrderUser(userId);
            return DubboResult.success(result);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return DubboResult.error(e.getMessage());
        }
    }
}
