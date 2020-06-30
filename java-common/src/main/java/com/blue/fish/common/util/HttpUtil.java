package com.blue.fish.common.util;

import com.github.qcloudsms.SmsSenderUtil;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author bluefish 2020-04-16
 * @version 1.0.0
 */
@Slf4j
public class HttpUtil {

    private static OkHttpClient okHttpClient;

    static String url = "https://yun.tim.qq.com/v5/tlssmssvr/sendsms";
    static String appId = "1400353309";
    static String mobiles = "18958060691"; //tel 的 mobile 字段的内容
    static String appKey = "bab6b5789ec770337520e2c73b987f3b"; //sdkappid 对应的 appkey，需要业务方高度保密
    static String[] contents = new String[]{new Random().nextInt(100000) + "", new Random().nextInt(10) + ""};
    static String sign = "BlueFish1989";
    static String templateId = "580138";
//    static String[] phoneNumbers = new String[]{"18958060691", "18072934231"};
    static String[] phoneNumbers = new String[]{"+8618072934231"};

    static {
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.connectTimeout(3000, TimeUnit.SECONDS);
        okHttpClient = okBuilder.build();
    }

    public static void sendByOkHttp() throws Exception {
        long random = SmsSenderUtil.getRandom();
        long currentTime = SmsSenderUtil.getCurrentTime();
        String signature = SmsSenderUtil.calculateSignature(appKey, random, currentTime, mobiles);


        JSONObject body = new JSONObject()
                .put("tel", new JSONObject().put("mobile", mobiles).put("nationcode", "86"))
                .put("sign", "BlueFish1989")
                .put("tpl_id", "580138")
                .put("params", new ArrayList<>(Arrays.asList(contents)))
                .put("sig", signature)
                .put("time", currentTime)
                .put("extend", "")
                .put("ext", "");

        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("Conetent-Type", "application/json");
        Headers headers = Headers.of(headersMap);

        RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), body.toString().getBytes(StandardCharsets.UTF_8));

        // 写法1：
        HttpUrl httpUrl = new HttpUrl.Builder()
                .addQueryParameter("sdkappid", appId)
                .addQueryParameter("random", String.valueOf(random))
                .scheme("https")
                .host("yun.tim.qq.com")
                .addPathSegment("v5")
                .addPathSegment("tlssmssvr")
                .addPathSegment("sendsms")
                .build();

        Request request = new Request.Builder().url(httpUrl).headers(headers).post(requestBody).build();

        // 写法2：
        Request req = new Request.Builder().url(url).headers(headers).post(requestBody).build();
        HttpUrl build = req.url().newBuilder()
                .addQueryParameter("sdkappid", appId)
                .addQueryParameter("random", String.valueOf(random))
                .build();
        req = req.newBuilder().url(build).build();

        Response response = okHttpClient.newCall(request).execute();

        String result = Optional.ofNullable(response.body())
                .map(responseBody -> {
                    try {
                        return responseBody.string();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .orElse(null);

        System.out.println(result);

    }

    /**
     * 腾讯短信发送
     *
     * @param url         URL相关信息
     * @param headers     请求头相关信息
     * @param requestBody 请求体
     * @return 请求结果
     * @throws IOException IO异常
     */
    public static String sendTencentSms(HttpUrl url, Headers headers, RequestBody requestBody) throws IOException {
        Request request = new Request.Builder().url(url).headers(headers).post(requestBody).build();

        Response response = okHttpClient.newCall(request).execute();

        return getBody(response);
    }

    /**
     * 从 okHttp 的 Response 里获取对应的body
     *
     * @param response 请求响应结果
     * @return 请求响应体
     * @throws IOException IO
     */
    private static String getBody(Response response) throws IOException {
        if (!response.isSuccessful()) {
            throw new IOException("请求有错：" + response);
        }

        return Optional.ofNullable(response.body())
                .map(responseBody -> {
                    try {
                        return responseBody.string();
                    } catch (IOException e) {
                        log.error("请求结果解析失败", e);
                        return null;
                    }
                })
                .orElse(null);
    }


    public static void sendTencentByNewApi() throws Exception {
        String url = "https://sms.tencentcloudapi.com";
        String secretId = "AKIDxrgLPN0Zv1MYZztZaKeCTTWIn8L1L6GP";
        String secretKey = "1mGjjgfO4bsuemdGexEPJySfogUEySeZ";
//        String appId = "1300835141";

        JSONObject body = new JSONObject()
                .put("PhoneNumberSet.0", "+86" + mobiles)
                .put("Sign", "BlueFish1989")
                .put("TemplateID", "580138")
                .put("TemplateParamSet", contents)
                .put("params", new ArrayList<>(Arrays.asList(contents)))
                .put("SmsSdkAppid", appId);

        Map<String, String> headersMap = new HashMap<>();
        headersMap.put("Conetent-Type", "application/json");
        Headers headers = Headers.of(headersMap);

        RequestBody requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"), body.toString().getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder().url(url).headers(headers).post(requestBody).build();

        // 写法1：
        HttpUrl httpUrl = request.url().newBuilder()
                .addQueryParameter("Action", "SendSms")
                .addQueryParameter("Timestamp", (System.currentTimeMillis() / 1000) + "")
                .addQueryParameter("Nonce", String.valueOf(SmsSenderUtil.getRandom()))
                .addQueryParameter("SecretId", secretId)
                .addQueryParameter("Signature", "SendSms")
                .addQueryParameter("Version", "SendSms")
                .build();

        request = request.newBuilder().url(httpUrl).build();

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.body().string());
    }

    public static void sendByNewSdk() throws Exception {
        String secretId = "AKIDxrgLPN0Zv1MYZztZaKeCTTWIn8L1L6GP";
        String secretKey = "1mGjjgfO4bsuemdGexEPJySfogUEySeZ";
        Credential cred = new Credential(secretId, secretKey);

        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("sms.tencentcloudapi.com");

        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);

        SmsClient client = new SmsClient(cred, "ap-shanghai", clientProfile);

        SendSmsRequest req = new SendSmsRequest();

        req.setSmsSdkAppid(appId);
        req.setSign(sign);
        req.setTemplateID(templateId);
        req.setTemplateParamSet(contents);
        req.setPhoneNumberSet(phoneNumbers);

        SendSmsResponse res = client.SendSms(req);

        System.out.println(SendSmsResponse.toJsonString(res));

    }

    public static void main(String[] args) throws Exception {
        String phoneNumber = "189580606910";
        String[] phoneNumbers = new String[]{"18072934231"};
        log.info("~~~~contents: {}", Arrays.toString(contents));
        TencentSmsSender sender = new TencentSmsSender();
//        sender.sendSmsSingle(appId, appKey,"580138","BlueFish1989", contents, "86", phoneNumber);
//        sender.sendSmsMulti(appId, appKey,"580138","BlueFish1989", contents, "86", phoneNumbers);

        sendByNewSdk();

//        try{
//
//            Credential cred = new Credential("AKIDxrgLPN0Zv1MYZztZaKeCTTWIn8L1L6GP", "1mGjjgfO4bsuemdGexEPJySfogUEySeZ");
//
//            HttpProfile httpProfile = new HttpProfile();
//            httpProfile.setEndpoint("sms.tencentcloudapi.com");
//
//            ClientProfile clientProfile = new ClientProfile();
//            clientProfile.setHttpProfile(httpProfile);
//
//            SmsClient client = new SmsClient(cred, "ap-shanghai", clientProfile);
//
//            String params = "{\"PhoneNumberSet\":[\"+8618072934231\"],\"TemplateID\":\"580138\",\"Sign\":\"BlueFish1989\",\"TemplateParamSet\":[\"34567\",\"3\"],\"SmsSdkAppid\":\"1400353309\"}";
//            SendSmsRequest req = SendSmsRequest.fromJsonString(params, SendSmsRequest.class);
//
//            SendSmsResponse resp = client.SendSms(req);
//
//            System.out.println(SendSmsRequest.toJsonString(resp));
//        } catch (TencentCloudSDKException e) {
//            System.out.println(e.toString());
//        }
    }

    public static class HttpConstants {
        public static final String CONTENT_TYPE = "Conetent-Type";

        public static final String DEFAULT_CONTENT_TYPE = "application/json";

        public static final MediaType DEFAULT_MEDIA_TYPE = MediaType.get("application/json; charset=utf-8");
    }
}
