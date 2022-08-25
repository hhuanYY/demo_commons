package com.utils.Bean.utils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
public class MD5Util {
	
	public static MessageDigest getInstance() throws NoSuchAlgorithmException {
		return MessageDigest.getInstance("MD5");
	}
	
	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));

		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String md5(String origin) {
		String resultString = null;
		try {
			resultString = Base64.encodeBase64String(getInstance().digest(origin.getBytes("UTF-8")));
		} catch (Exception e) {
			throw new RuntimeException("计算MD5出错", e);
		}
		return resultString;
	}
	
	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String str = "content=chendmtest&userAccountIDList=247123429778317312&version=2.0&appID=224357176743211009×tamp=1646187679596&title=%E6%B5%8B%E8%AF%95%E6%A0%87%E9%A2%98&messageType=TEXT&receiverChannelList=DINGTALK";
		JSONObject json = new JSONObject();
		json.put("content","chendmtest");
		json.put("userAccountIDList","247123429778317312");
		json.put("version","2.0");
		json.put("appID","224357176743211009");
		json.put("timestamp","1646187798017");
		json.put("title","this is chendm test");
		json.put("messageType","TEXT");
		json.put("receiverChannelList","DINGTALK");
		String str01 = " {'content': 'chendmtest', 'userAccountIDList': '247123429778317312', 'version': '2.0', 'appID': '224357176743211009', 'timestamp': '1646187798017', 'title': 'this is chendm test', 'messageType': 'TEXT', 'receiverChannelList': 'DINGTALK'}";

		String str02 = "{\n" +
				"    \"messageType\": \"TEXT\",\n" +
				"    \"userAccountIDList\": \"247123429778317312\",\n" +
				"    \"appID\": \"224357176743211009\",\n" +
				"    \"title\": \"this is chendm test\",\n" +
				"    \"receiverChannelList\": \"DINGTALK\",\n" +
				"    \"version\": \"2.0\",\n" +
				"    \"content\": \"chendmtest\",\n" +
				"    \"timestamp\": \"1646187798017\"\n" +
				"}";


		String str03 = "{\"appID\":\"224357176743211009\"}";

		System.out.println("1:"+Base64.encodeBase64String(MessageDigest.getInstance("MD5").digest(str03.getBytes("UTF-8"))));

		System.out.println(md5(str03));
	}
}
