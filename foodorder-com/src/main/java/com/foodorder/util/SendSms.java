package com.foodorder.util;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 腾讯短信发送
 */
public class SendSms {

    private static final Logger logger = LoggerFactory.getLogger(SendSms.class);

    //秘钥
    private static final String SECRETID = "AKID0rTqxmRhuqY0DOKxTlm8D9sMbrscHRbW";

    private static final String SECRETKEY = "oN0PXVDjz1mU1MXRELHsVw98zQeZEm4J";

    //模板ID
    private static final String TEMPLATEID = "720042";

    //应用ID
    private static final String SDKAPPID = "1400425126";

    //签名
    private static final String SIGN = "foodsunshune";

    public static String sendSmsTen(String phone,String code,String time) {
        String result = "";
        try{
            Credential cred = new Credential(SECRETID, SECRETKEY);

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            SmsClient client = new SmsClient(cred, "", clientProfile);

            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {"+86"+ phone};
            req.setPhoneNumberSet(phoneNumberSet1);

            String[] templateParamSet1 = {code, time};
            req.setTemplateParamSet(templateParamSet1);

            req.setTemplateID(TEMPLATEID);
            req.setSmsSdkAppid(SDKAPPID);
            req.setSign(SIGN);

            SendSmsResponse resp = client.SendSms(req);
            String response = SendSmsResponse.toJsonString(resp);
            return response;
        } catch (TencentCloudSDKException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
