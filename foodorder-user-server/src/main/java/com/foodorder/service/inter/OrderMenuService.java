package com.foodorder.service.inter;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.inter.user.bean.OrderMenu;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;

public interface OrderMenuService {

    PagedResult<OrderMenu> selectOrderMenuList(JSONObject jsonObject, Integer pageSize, Integer pageNo);

    Boolean insertOrderMenu(JSONObject orderMenu);
}
