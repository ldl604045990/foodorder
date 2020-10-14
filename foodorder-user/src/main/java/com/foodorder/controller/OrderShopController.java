package com.foodorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.foodorder.controller.base.BaseController;
import com.foodorder.inter.user.bean.OrderShop;
import com.foodorder.inter.user.dto.OrderShopDto;
import com.foodorder.inter.user.web.IDuOrderShop;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;
import com.foodorder.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderShop")
public class OrderShopController extends BaseController {

    @Autowired
    private IDuOrderShop iDuOrderShop;

    @RequestMapping(value = "/shopList",method = RequestMethod.POST)
    public ResultBean<PagedResult<OrderShopDto>> shopList(String params,@RequestParam(defaultValue = "1") Integer pageNo,
                                                          @RequestParam(defaultValue = "10")Integer pageSize){
        JSONObject json = getJSONParams(params);
        DubboResult<PagedResult<OrderShopDto>> dubboResult = iDuOrderShop.orderShopList(json,pageNo,pageSize);
        if(dubboResult.getBusiCode()==DubboResult.BUSI_CODE_200){
            return ResultBean.success(dubboResult.getData());
        }
        return ResultBean.error(dubboResult.getMessage());
    }

    /**
     * 注册店家
     * @return
     */
    @RequestMapping(value = "/registerShop",method = RequestMethod.POST)
    public ResultBean<Boolean> registerShop(@RequestParam(required = true,name = "params") String params){
        JSONObject json = getJSONParams(params);
        DubboResult<Boolean> dubboResult = iDuOrderShop.registerOrderShop(json);
        if(dubboResult.getBusiCode()==DubboResult.BUSI_CODE_200){
            return ResultBean.success(dubboResult.getData());
        }
        return ResultBean.error(dubboResult.getMessage());
    }
}

