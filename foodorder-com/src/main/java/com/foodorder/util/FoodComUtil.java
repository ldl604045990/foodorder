package com.foodorder.util;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.foodorder.constant.ConstantKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FoodComUtil {

    private static final Logger logger = LoggerFactory.getLogger(FoodComUtil.class);

    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO( String mobiles){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0,5-9]))\\d{8}$");
            Matcher m = regex .matcher(mobiles);
            flag = m.matches();
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 注册用户，解密
     * @param password
     * @return
     */
    public static String registerJm(String password){
        String reuslt = "";
        try{
            SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
            SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, ConstantKey.LOGIN_PASSWORD_KEY.getBytes());
            reuslt = aes.decryptStr(password);
        }catch (Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return reuslt;
    }


    public static void main(String[] args) {
        /*SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, ConstantKey.LOGIN_PASSWORD_KEY.getBytes());
        System.out.println(aes.decryptStr("4b8e1014ae7e89b1006999be51d552a4"));*/

       /* String phone = "15986800355";
        Boolean bol = FoodComUtil.isMobileNO(phone);
        System.out.println(bol);*/

        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, ConstantKey.LOGIN_PASSWORD_KEY.getBytes());
        String userKeyEn = aes.encryptHex("admin");
        System.out.println(userKeyEn);

    }
}
