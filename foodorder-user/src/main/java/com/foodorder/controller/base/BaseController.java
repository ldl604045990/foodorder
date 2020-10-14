package com.foodorder.controller.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.foodorder.constant.TimingConstant;
import com.foodorder.inter.user.bean.OrderUser;
import com.foodorder.redisconf.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private HttpServletRequest request;


    public JSONObject getJSONParams(String params){
        try {
            if (params != null) {
                params = params.replaceAll("&lt;","<").replaceAll("&gt;",">").replaceAll("&nbsp;"," ");
            }
            logger.info("请求参数params:" +params);
            JSONObject jsonParams = null;
            if (null != params && !"".equals(params)) {
                jsonParams = JSON.parseObject(params);
            } else {
                jsonParams = new JSONObject();
            }

            OrderUser sessionBean = getUserSession();
            if (sessionBean != null) {
                jsonParams.put("userId",sessionBean.getId());
                jsonParams.put("userName",sessionBean.getUserName());
                jsonParams.put("userType",sessionBean.getUserType());
            }
            return jsonParams;
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        return new JSONObject();
    }

    public OrderUser getUserSession(){
        String userKeyEn = request.getHeader("userKeyEn");
        String userBean = redisUtil.getObject(userKeyEn);
        if(userBean==null){
            return null;
        }
        JSONObject userSessionJSON = JSON.parseObject(userBean);
        OrderUser orderUser = JSON.toJavaObject(userSessionJSON, OrderUser.class);
        String userKey = "login_key_" + orderUser.getId();  //判断唯一登录

        redisUtil.saveObject(userKey,userKeyEn, TimingConstant.LOGIN_EX_TIMING.getKey());
        redisUtil.saveObject(userKeyEn,userBean, TimingConstant.LOGIN_EX_TIMING.getKey());
        return orderUser;
    }


}
