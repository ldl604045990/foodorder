package com.foodorder.service.inter;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.inter.user.bean.OrderShop;
import com.foodorder.inter.user.dto.OrderShopDto;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;

public interface OrderShopService {

    PagedResult<OrderShopDto> getPagedOrderShop(JSONObject params, Integer pageNo, Integer pageSize);

    Boolean registerOrderShop(JSONObject json);

}
