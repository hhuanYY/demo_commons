package com.utils.日常api.字符串相关;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author: yuanyinhuan
 * @date: 2022/2/28 11:48
 */
public class Test {

    static final String SIGN_HEADERS = "x-gate-api-version,x-ca-nonce,x-ca-key,x-ca-timestamp,x-ca-signature-method";

    public static List<String> ENABLE_HEADERS = new ArrayList<>();

    public static String APP_SECRET = "application/json";

    static {
        String[] split = SIGN_HEADERS.split(",");
        Collections.addAll( ENABLE_HEADERS,split );
    }


    private static String generateHeaders(final Map<String, String> headersMap) {
        Set<String> keySet = headersMap.keySet();
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        Arrays.sort(keyArray);
        StringBuilder sb = new StringBuilder();
        //参数值为null或空字符串，则不参与签名
        for (String k : keyArray) {
            if(ENABLE_HEADERS.contains(k)){
                sb.append(k).append(":").append(headersMap.get(k)).append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
//        String str = "{'x-ca-signature-method': 'HmacSHA256', 'x-ca-timestamp': 1646019481622, 'x-gate-api-version': '2.0', 'x-ca-key': '1472763856852906051', 'Date': '2022-02-28', 'x-ca-nonce': 'd475a0f6-9847-11ec-a4be-005056b3289c', 'x-ca-signature-headers': 'x-gate-api-version,x-ca-nonce,x-ca-key,x-ca-timestamp,x-ca-signature-method', 'Content-Type': 'application/json', 'Accept': 'application/json', 'Content-MD5': 'a80f918733c34e616b73ec89a3f73913'}";
//        Map<String, String> map = JSON.parseObject(str, new TypeReference<Map<String, String>>() {});
//        generateHeaders(map);
//

        String str = "POST" +
                "application/json\n" +
                "application/json\n" +
                "2022-02-28\n" +
                "x-ca-nonce:e69e736e-9885-11ec-8827-005056b3289c\n" +
                " x-ca-signature-method: HmacSHA256\n" +
                " x-ca-timestamp: 1646046140886\n" +
                " x-gate-api-version: 2.0\n" +
                " x-ca-key: 1472763856852906051/message/send";




        generateSignature(str);
    }



    private static String generateSignature(String stringToSign) throws Exception {
        //分配的appSecret
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        byte[] keyBytes = APP_SECRET.getBytes( StandardCharsets.UTF_8 );
        hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length, "HmacSHA256"));
        String s = new String(Base64.encodeBase64(hmacSha256.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8))), "UTF-8");
        System.err.println(s);
        return s;
    }


}
