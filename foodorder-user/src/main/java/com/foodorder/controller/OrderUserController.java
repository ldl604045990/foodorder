package com.foodorder.controller;


import com.alibaba.fastjson.JSONObject;
import com.foodorder.controller.base.BaseController;
import com.foodorder.inter.user.bean.OrderUser;
import com.foodorder.inter.user.web.IDuOrderUser;
import com.foodorder.util.DubboResult;
import com.foodorder.util.PagedResult;
import com.foodorder.util.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderUser")
public class OrderUserController extends BaseController {


    @Autowired
    private IDuOrderUser iDuOrderUser;


    @RequestMapping("/login")
    public ResultBean<OrderUser> login(@RequestParam(name = "userName")String userName, @RequestParam(name = "pwd")String pwd){
        DubboResult<OrderUser> dubboResult = iDuOrderUser.login(userName,pwd);
        if(dubboResult.getBusiCode()==DubboResult.BUSI_CODE_200){
            return ResultBean.success(dubboResult.getData());
        }
        return ResultBean.error(dubboResult.getMessage());
    }

    @RequestMapping("/registerUser")
    public ResultBean<Boolean> register(@RequestParam(required = true,name = "params") String params){
        JSONObject json = getJSONParams(params);
        DubboResult<Boolean> dubboResult = iDuOrderUser.register(json);
        if(dubboResult.getBusiCode()==DubboResult.BUSI_CODE_200){
            return ResultBean.success("注册成功！",dubboResult.getData());
        }
        return ResultBean.error(dubboResult.getMessage());
    }

    @RequestMapping("/disableOrderUser/{userId}")
    public ResultBean<?> disableOrderUser(@PathVariable Integer userId){
        DubboResult<?> dubboResult = iDuOrderUser.disableOrderUser(userId);
        if(dubboResult.getBusiCode()==DubboResult.BUSI_CODE_200){
            return ResultBean.success(dubboResult.getData());
        }
        return ResultBean.error(dubboResult.getMessage());
    }

    @RequestMapping("/deleteOrderUser/{userId}")
    public ResultBean<?> deleteOrderUser(@PathVariable Integer userId){
        DubboResult<?> dubboResult = iDuOrderUser.deleteOrderUser(userId);
        if(dubboResult.getBusiCode()==DubboResult.BUSI_CODE_200){
            return ResultBean.success(dubboResult.getData());
        }
        return ResultBean.error(dubboResult.getMessage());
    }

    @RequestMapping("/getOrderUserList")
    public ResultBean<?> getOrderUserList(String params,@RequestParam(defaultValue = "1") Integer pageNo,
                                          @RequestParam(defaultValue = "10")Integer pageSize){
        JSONObject json = getJSONParams(params);
        DubboResult<PagedResult<OrderUser>> dubboResult = iDuOrderUser.orderUserList(json,pageNo,pageSize);
        if(dubboResult.getBusiCode()==DubboResult.BUSI_CODE_200){
            return ResultBean.success(dubboResult.getData());
        }
        return ResultBean.error(dubboResult.getMessage());
    }

}
