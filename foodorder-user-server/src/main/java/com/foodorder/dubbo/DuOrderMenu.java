package com.foodorder.dubbo;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.inter.user.bean.OrderMenu;
import com.foodorder.inter.user.web.IDuOrderMenu;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;

public class DuOrderMenu implements IDuOrderMenu {


    @Override
    public DubboResult<PagedResult<OrderMenu>> getOrderMenuList(JSONObject jsonObject, Integer pageSize, Integer pageNo) {
        return null;
    }

    @Override
    public DubboResult<Boolean> saveOrderMenu(JSONObject orderMenu) {
        return null;
    }


}
