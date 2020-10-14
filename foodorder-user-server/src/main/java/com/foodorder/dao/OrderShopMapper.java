package com.foodorder.dao;

import com.foodorder.dao.base.IBaseMapper;
import com.foodorder.inter.user.bean.OrderShop;
import com.foodorder.inter.user.dto.OrderShopDto;

import java.util.List;

public interface OrderShopMapper extends IBaseMapper<OrderShop,Integer> {


    List<OrderShopDto> getPageOrderShopByPrams(String values);
}