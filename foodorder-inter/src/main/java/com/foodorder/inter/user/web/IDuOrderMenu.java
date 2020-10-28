package com.foodorder.inter.user.web;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.inter.user.bean.OrderMenu;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;

public interface IDuOrderMenu {

    DubboResult<PagedResult<OrderMenu>> getOrderMenuList(JSONObject jsonObject,Integer pageSize,Integer pageNo);

    DubboResult<Boolean> saveOrderMenu(JSONObject orderMenu);

}
