package com.foodorder.service;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.constant.DeleteFlag;
import com.foodorder.constant.OrderUserType;
import com.foodorder.dao.OrderMenuMapper;
import com.foodorder.inter.user.bean.OrderMenu;
import com.foodorder.inter.user.dto.OrderShopDto;
import com.foodorder.service.inter.OrderMenuService;
import com.foodorder.util.BeanResultUtil;
import com.foodorder.util.PagedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderMenuServiceImpl implements OrderMenuService {

    @Autowired
    private OrderMenuMapper orderMenuMapper;


    @Override
    public PagedResult<OrderMenu> selectOrderMenuList(JSONObject jsonObject, Integer pageSize, Integer pageNo) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" delete_flag = " + DeleteFlag.DELETE_FALSE.getKey());

        Integer menuLevel = jsonObject.getInteger("menuLevel");
        if(menuLevel==null)menuLevel=1;
        stringBuffer.append(" and menu_level = " + menuLevel);

        Integer shopId = jsonObject.getInteger("shopId");
        stringBuffer.append(" and shop_id = " + shopId);

        List<OrderMenu> result = orderMenuMapper.selectOrderMenuList(stringBuffer.toString());
        return BeanResultUtil.toPagedResult(result);
    }

    @Override
    public Boolean insertOrderMenu(JSONObject orderMenu) {
        return null;
    }
}
