package com.foodorder.dao;

import com.foodorder.dao.base.IBaseMapper;
import com.foodorder.inter.user.bean.OrderMenu;

import java.util.List;

public interface OrderMenuMapper extends IBaseMapper<OrderMenu,Integer> {

    List<OrderMenu> selectOrderMenuList(String values);

}