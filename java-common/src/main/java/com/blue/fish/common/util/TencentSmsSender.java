package com.blue.fish.common.util;

import com.alibaba.fastjson.JSON;
import com.blue.fish.common.util.test.MultiSmsSenderResult;
import com.blue.fish.common.util.test.SingleSmsSenderResult;
import com.github.qcloudsms.SmsSenderUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.RequestBody;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author bluefish 2020-04-16
 * @version 1.0.0
 */
@Slf4j
public class TencentSmsSender {

    private static Map<String, String> SMS_SEND_URL_INFO = new ConcurrentHashMap<>();

   static  {
        // 腾讯短信接口：域名+path，为公共参数
        SMS_SEND_URL_INFO.put("scheme", "https");
        SMS_SEND_URL_INFO.put("host", "yun.tim.qq.com");
        SMS_SEND_URL_INFO.put("version", "v5");
        SMS_SEND_URL_INFO.put("path", "tlssmssvr");
        // 单发接口：sendsms
        SMS_SEND_URL_INFO.put("singleSendApi", "sendsms");
        // 群发接口：sendmultisms2
        SMS_SEND_URL_INFO.put("multiSendApi", "sendmultisms2");
    }

    /**
     * 腾讯云单发短信
     *
     * @param appId       短信应用appId
     * @param appKey      短信应用appKey
     * @param templateId  短信模板id
     * @param sign        短信签名
     * @param contents    模板参数，与短信模板id结合使用，没有传空数组即可
     * @param nationCode  国家编码，默认为：86
     * @param phoneNumber 手机号码
     */
    public void sendSmsSingle(@NotEmpty String appId, @NotEmpty String appKey, @NotEmpty String templateId, @NotEmpty String sign,
                              @NotEmpty String[] contents, @NotEmpty String nationCode, @NotEmpty String phoneNumber) {

        try {
            long random = SmsSenderUtil.getRandom();
            long currentTime = SmsSenderUtil.getCurrentTime();
            // 腾讯云凭证
            String signature = SmsSenderUtil.calculateSignature(appKey, random, currentTime, phoneNumber);
            // 默认发国内
            nationCode = StringUtils.isEmpty(nationCode) ? "86" : nationCode;

            // 构建请求体
            JSONObject body = new JSONObject()
                    // 手机号码拼接 国家编码 + 手机号码
                    .put("tel", new JSONObject().put("mobile", phoneNumber).put("nationcode", nationCode))
                    .put("sign", sign)
                    .put("tpl_id", templateId)
                    .put("params", new ArrayList<>(Arrays.asList(contents)))
                    .put("sig", signature)
                    .put("time", currentTime)
                    .put("extend", "")
                    .put("ext", "");

            Headers headers = createHeaders();

            RequestBody requestBody = RequestBody.create(HttpUtil.HttpConstants.DEFAULT_MEDIA_TYPE, body.toString().getBytes(StandardCharsets.UTF_8));

            HttpUrl httpUrl = createHttpUrl(appId, random, "singleSendApi");

            String result = HttpUtil.sendTencentSms(httpUrl, headers, requestBody);
            SingleSmsSenderResult senderResult = JSON.parseObject(result, SingleSmsSenderResult.class);
            log.info("腾讯单发短信-sendSmsSingle 发送回执:{}", JSON.toJSONString(senderResult));
            if (senderResult == null || senderResult.getResult() == 60008)
                throw new RuntimeException("微信短信服务异常，请求超时");
            else {
                if (senderResult.getResult() != 0)
                    throw new RuntimeException("微信短信服务异常，errCode:" + senderResult.getResult() + ",errMsg:" + senderResult.getErrMsg());
            }
        } catch (Exception e) {
            log.error("腾讯单发短信-sendSmsSingle error message:", e);
            throw new RuntimeException(e.getLocalizedMessage());
        }

    }

    /**
     * 腾讯云群发短信
     *
     * @param appId        短信应用appId
     * @param appKey       短信应用appKey
     * @param templateId   短信模板id
     * @param sign         短信签名
     * @param contents     模板参数，与短信模板id结合使用，没有传空数组即可
     * @param nationCode   国家编码，默认为：86
     * @param phoneNumbers 手机号码，数组
     */
    public void sendSmsMulti(@NotEmpty String appId, @NotEmpty String appKey, @NotEmpty String templateId, @NotEmpty String sign,
                             @NotEmpty String[] contents, @NotEmpty String nationCode, @NotEmpty String[] phoneNumbers) {
        try {
            long random = SmsSenderUtil.getRandom();
            long currentTime = SmsSenderUtil.getCurrentTime();
            // 腾讯云凭证
            String signature = SmsSenderUtil.calculateSignature(appKey, random, currentTime, phoneNumbers);
            // 默认发国内
            nationCode = StringUtils.isEmpty(nationCode) ? "86" : nationCode;

            // 构建请求体
            JSONObject body = new JSONObject()
                    // 手机号码拼接 国家编码 + 手机号码
                    .put("tel", toTel(nationCode, phoneNumbers))
                    .put("sign", sign)
                    .put("tpl_id", templateId)
                    .put("params", new ArrayList<>(Arrays.asList(contents)))
                    .put("sig", signature)
                    .put("time", currentTime)
                    .put("extend", "")
                    .put("ext", "");

            Headers headers = createHeaders();

            RequestBody requestBody = RequestBody.create(HttpUtil.HttpConstants.DEFAULT_MEDIA_TYPE, body.toString().getBytes(StandardCharsets.UTF_8));

            HttpUrl httpUrl = createHttpUrl(appId, random, "multiSendApi");

            String result = HttpUtil.sendTencentSms(httpUrl, headers, requestBody);
            System.out.println(result);
            MultiSmsSenderResult senderResult = JSON.parseObject(result, MultiSmsSenderResult.class);

            log.info("腾讯群发短信-sendSmsMulti 发送回执:{}", JSON.toJSONString(senderResult));
            if (senderResult == null || senderResult.getResult() == 60008)
                throw new Exception("微信短信服务异常，请求超时");
            else {
                if (senderResult.getResult() != 0)
                    throw new RuntimeException("微信短信服务异常，errCode:" + senderResult.getResult() + ",errMsg:" + senderResult.getErrMsg());
            }
        } catch (Exception e) {
            log.error("腾讯群发短信-sendSmsMulti error message:", e);
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }

    /**
     * 创建请求url，并设置公共参数
     *
     * @param appId   appId
     * @param random  随机数
     * @param apiName 对应api的名称
     * @return 实际请求的url
     */
    private HttpUrl createHttpUrl(@NotEmpty String appId, long random, String apiName) {
        return new HttpUrl.Builder()
                .scheme(SMS_SEND_URL_INFO.get("scheme"))
                .host(SMS_SEND_URL_INFO.get("host"))
                .addPathSegment(SMS_SEND_URL_INFO.get("version"))
                .addPathSegment(SMS_SEND_URL_INFO.get("path"))
                .addPathSegment(SMS_SEND_URL_INFO.get(apiName))
                // 需要额外的公共参数
                .addQueryParameter("sdkappid", appId)
                .addQueryParameter("random", String.valueOf(random))
                .build();
    }

    /**
     * 创建Header
     *
     * @return header
     */
    private Headers createHeaders() {
        Map<String, String> headersMap = new HashMap<>();
        headersMap.put(HttpUtil.HttpConstants.CONTENT_TYPE, HttpUtil.HttpConstants.DEFAULT_CONTENT_TYPE);
        return Headers.of(headersMap);
    }

    /**
     * 组装群发电话号码
     *
     * @param nationCode 国家编码
     * @param phoneNumbers 多个号码，数组
     * @return
     */
    private List<JSONObject> toTel(String nationCode, String[] phoneNumbers) {
        List<JSONObject> phones = new ArrayList<>();
        for (String phoneNumber : phoneNumbers) {
            JSONObject phone = new JSONObject();
            phone.put("nationcode", nationCode);
            phone.put("mobile", phoneNumber);
            phones.add(phone);
        }
        return phones;
    }
}
