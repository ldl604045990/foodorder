package com.foodorder.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.foodorder.constant.DeleteFlag;
import com.foodorder.constant.OrderUserType;
import com.foodorder.dao.OrderShopMapper;
import com.foodorder.inter.user.bean.OrderShop;
import com.foodorder.inter.user.dto.OrderShopDto;
import com.foodorder.service.inter.OrderShopService;
import com.foodorder.util.BeanResultUtil;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderShopServiceImpl implements OrderShopService {

    @Autowired
    private OrderShopMapper orderShopMapper;

    @Override
    public PagedResult<OrderShopDto> getPagedOrderShop(JSONObject params, Integer pageNo, Integer pageSize) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" delete_flag = " + DeleteFlag.DELETE_FALSE.getKey());
        Integer userType = params.getInteger("userType");
        if(userType == OrderUserType.MERCHANT_LOGIN.getKey()){
            stringBuffer.append(" user_id = " + params.getInteger("userId"));
        }
        PageHelper.startPage(pageNo,pageSize);
        List<OrderShopDto> result = orderShopMapper.getPageOrderShopByPrams(stringBuffer.toString());
        return BeanResultUtil.toPagedResult(result);
    }

    @Override
    public Boolean registerOrderShop(JSONObject json) {
        OrderShop orderShop = JSON.toJavaObject(json, OrderShop.class);
        if(orderShop.getId()!=null){
            orderShop.setUpdateBy(orderShop.getUserId());
            orderShop.setUpdateDate(new Date());
            orderShopMapper.updateByPrimaryKeySelective(orderShop);
        } else {
            orderShop.setCreateBy(orderShop.getUserId());
            orderShop.setCreateDate(new Date());
            orderShopMapper.insertSelective(orderShop);
        }
        return true;
    }
}
