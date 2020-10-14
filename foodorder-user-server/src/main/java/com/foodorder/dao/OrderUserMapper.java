package com.foodorder.dao;

import com.foodorder.dao.base.IBaseMapper;
import com.foodorder.inter.user.bean.OrderUser;
import com.foodorder.inter.user.dto.OrderShopDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderUserMapper extends IBaseMapper<OrderUser,Integer> {

    /**登录*/
    OrderUser selectOrderUserByUserName(@Param("userName") String userName);


    List<OrderUser> getPageOrderUserByPrams(String values);
}