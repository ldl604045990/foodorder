package com.foodorder.service;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.foodorder.constant.DeleteFlag;
import com.foodorder.constant.OrderUserType;
import com.foodorder.constant.ConstantKey;
import com.foodorder.constant.TimingConstant;
import com.foodorder.dao.OrderUserMapper;
import com.foodorder.exception.IllegalParamException;
import com.foodorder.inter.user.bean.OrderUser;
import com.foodorder.redisconf.RedisUtil;
import com.foodorder.service.inter.OrderUserService;
import com.foodorder.util.BeanResultUtil;
import com.foodorder.util.PagedResult;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderUserServiceImpl implements OrderUserService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private OrderUserMapper orderUserMapper;

    @Override
    public OrderUser login(String userName, String userPwd) {
        OrderUser orderUser = orderUserMapper.selectOrderUserByUserName(userName);
        if(orderUser.getDeleteFlag()==DeleteFlag.DELETE_TRUE.getKey()){
            throw IllegalParamException.throwMsgException("该用户已禁用！");
        }
        if(orderUser==null){
            throw IllegalParamException.throwMsgException("不存在该用户！");
        }

        //构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, ConstantKey.LOGIN_PASSWORD_KEY.getBytes());
        String decryptStr = aes.decryptStr(orderUser.getUserPwd());
        if(!decryptStr.equals(userPwd)){
            throw IllegalParamException.throwMsgException("密码不正确");
        }

        String userKey = ConstantKey.LOGIN_KEY + orderUser.getId();  //判断唯一登录
        String loginStatsValue = redisUtil.getObject(userKey);
        if(StringUtils.isNotEmpty(loginStatsValue)){
            //还没失效，可能存在多个人登录  将先登录的 挤出去
            redisUtil.deleteKey(loginStatsValue);
        }

        //随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

        String userKeyEn = aes.encryptHex(orderUser.getId().toString());  //加密
        redisUtil.saveObject(userKey, userKeyEn, TimingConstant.LOGIN_EX_TIMING.getKey());
        redisUtil.saveObject(userKeyEn, JSON.toJSON(orderUser).toString(), TimingConstant.LOGIN_EX_TIMING.getKey());
        orderUser.setUserPwd(userKeyEn);
        return orderUser;
    }

    public static void main(String[] args) {
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, ConstantKey.LOGIN_PASSWORD_KEY.getBytes());
        System.out.println(aes.decryptStr("4b8e1014ae7e89b1006999be51d552a4"));
    }

    @Override
    public Boolean register(JSONObject json) {
        OrderUser user = JSON.toJavaObject(json, OrderUser.class);
        OrderUser orderUser = orderUserMapper.selectOrderUserByUserName(user.getUserName());
        if(orderUser!=null){
            throw IllegalParamException.throwMsgException("用户已存在！");
        }

        //构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, ConstantKey.LOGIN_PASSWORD_KEY.getBytes());
        String userKeyEn = aes.encryptHex(user.getUserPwd());  //加密
        user.setUserPwd(userKeyEn);

        user.setUserType(OrderUserType.MERCHANT_LOGIN.getKey());
        user.setCreateDate(new Date());
        user.setCreateBy(-1);
        user.setDeleteFlag(DeleteFlag.DELETE_FALSE.getKey());
        user.setIsDisable(DeleteFlag.DELETE_FALSE.getKey());
        orderUserMapper.insertSelective(user);
        return true;
    }

    @Override
    public PagedResult<OrderUser> getOrderUserList(JSONObject jsonObject, Integer pageSize, Integer pageNo) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" delete_flag = " + DeleteFlag.DELETE_FALSE.getKey());
        stringBuffer.append(" and user_type = " + OrderUserType.MERCHANT_LOGIN.getKey());
        PageHelper.startPage(pageNo,pageSize);
        List<OrderUser> result = orderUserMapper.getPageOrderUserByPrams(stringBuffer.toString());
        return BeanResultUtil.toPagedResult(result);
    }

    @Override
    public Boolean disableOrderUser(Integer userId) {
        OrderUser orderUser = orderUserMapper.selectByPrimaryKey(userId);
        if(orderUser.getIsDisable()==DeleteFlag.DELETE_TRUE.getKey()){
            orderUser.setIsDisable(DeleteFlag.DELETE_FALSE.getKey());
        } else {
            orderUser.setIsDisable(DeleteFlag.DELETE_TRUE.getKey());
        }
        orderUserMapper.updateByPrimaryKeySelective(orderUser);

        String userKey = ConstantKey.LOGIN_KEY + orderUser.getId();  //判断唯一登录
        String loginStatsValue = redisUtil.getObject(userKey);
        if(StringUtils.isNotEmpty(loginStatsValue)){
            redisUtil.deleteKey(loginStatsValue);
        }
        return true;
    }

    @Override
    public Boolean deleteOrderUser(Integer userId) {
        OrderUser orderUser = orderUserMapper.selectByPrimaryKey(userId);
        if(orderUser.getDeleteFlag()==DeleteFlag.DELETE_TRUE.getKey()){
            orderUser.setDeleteFlag(DeleteFlag.DELETE_FALSE.getKey());
        } else {
            orderUser.setDeleteFlag(DeleteFlag.DELETE_TRUE.getKey());
        }
        orderUserMapper.updateByPrimaryKeySelective(orderUser);

        String userKey = ConstantKey.LOGIN_KEY + orderUser.getId();  //判断唯一登录
        String loginStatsValue = redisUtil.getObject(userKey);
        if(StringUtils.isNotEmpty(loginStatsValue)){
            redisUtil.deleteKey(loginStatsValue);
        }
        return true;
    }

}
