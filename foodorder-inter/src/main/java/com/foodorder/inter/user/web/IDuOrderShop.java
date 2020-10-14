package com.foodorder.inter.user.web;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.inter.user.bean.OrderShop;
import com.foodorder.inter.user.dto.OrderShopDto;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;

import java.util.Map;

/**
 * 店铺
 * @author ldl
 * @date 2020-08-20
 */
public interface IDuOrderShop {

    /**
     * 注册商家
     * @return
     */
    DubboResult<Boolean> registerOrderShop(JSONObject json);

    /**
     * 查询店铺list
     * @param params
     * @return
     */
    DubboResult<PagedResult<OrderShopDto>> orderShopList(JSONObject params,Integer pageNo,Integer pageSize);
}
