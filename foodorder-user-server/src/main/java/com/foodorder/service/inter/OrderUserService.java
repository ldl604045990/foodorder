package com.foodorder.service.inter;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.inter.user.bean.OrderUser;
import com.foodorder.util.PagedResult;

public interface OrderUserService {


    OrderUser login(String userName, String userPwd);

    Boolean register(JSONObject orderUser);

    PagedResult<OrderUser> getOrderUserList(JSONObject jsonObject, Integer pageSize, Integer pageNo);

    Boolean disableOrderUser(Integer userId);

    Boolean deleteOrderUser(Integer userId);

    Boolean sendSmsTen(String phone);
}
