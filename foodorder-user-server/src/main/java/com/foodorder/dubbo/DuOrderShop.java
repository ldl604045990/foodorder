package com.foodorder.dubbo;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.inter.user.bean.OrderShop;
import com.foodorder.inter.user.dto.OrderShopDto;
import com.foodorder.inter.user.web.IDuOrderShop;
import com.foodorder.service.inter.OrderShopService;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class DuOrderShop implements IDuOrderShop {

    private static final Logger logger = LoggerFactory.getLogger(DuOrderUser.class);

    @Autowired
    private OrderShopService orderShopService;

    @Override
    public DubboResult<Boolean> registerOrderShop(JSONObject json) {
        try {
            orderShopService.registerOrderShop(json);
            return DubboResult.success(true);
        } catch (Exception e) {
            logger.error(" 注册商户异常 ："+e.getMessage());
            return DubboResult.error("注册商户异常："+e.getMessage());
        }
    }

    @Override
    public DubboResult<PagedResult<OrderShopDto>> orderShopList(JSONObject params, Integer pageNo, Integer pageSize) {
        try {
            PagedResult<OrderShopDto> pagedResult = orderShopService.getPagedOrderShop(params,pageNo,pageSize);
            return DubboResult.success(pagedResult);
        } catch (Exception e) {
            logger.error(" 获取商户列表异常 ："+e.getMessage());
            return DubboResult.error("获取商户列表异常："+e.getMessage());
        }
    }


}
