package com.dossen.cgi.application.utils;

import org.apache.catalina.filters.Constants;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;



/**
 * 签名工具
 */
//public class SignUtil {
//	public final static ThreadLocal<String> SIGN_STRING = new ThreadLocal<String>();
//
//	public static void assertNotNull(String key, Object value) {
//		if (value == null) {
//			throw new AppException("缺少参数" + key, AuthorizeExceptionCode.PARAMETER_NOT_FOUNT, "");
//		}
//	}
//    /**
//     * 计算签名
//     *
//     * @param secret APP密钥
//     * @param method HttpMethod
//     * @param path
//     * @param headers
//     * @param querys
//     * @param bodys
//     * @param signHeaderPrefixList 自定义参与签名Header前缀
//     * @return 签名后的字符串
//     */
//    public static String sign(String secret, String method, String path,
//    							Map<String, String> headers,
//    							Map<String, String> querys,
//    							Map<String, String> bodys,
//    							List<String> signHeaderPrefixList,
//    							boolean lowcaseCompatible) {
//        try {
//            Mac hmacSha256 = Mac.getInstance(Constants.HMAC_SHA256);
//            byte[] keyBytes = secret.getBytes(Constants.ENCODING);
//            hmacSha256.init(new SecretKeySpec(keyBytes, 0, keyBytes.length, Constants.HMAC_SHA256));
//
//            return new String(Base64.encodeBase64(
//                    hmacSha256.doFinal(buildStringToSign(method, path, headers, querys, bodys, signHeaderPrefixList, lowcaseCompatible)
//                            .getBytes(Constants.ENCODING))),
//                    Constants.ENCODING);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 构建待签名字符串
//     * @param method
//     * @param path
//     * @param headers
//     * @param querys
//     * @param bodys
//     * @param signHeaderPrefixList
//     * @return
//     */
//    private static String buildStringToSign(String method, String path,
//    										Map<String, String> headers,
//    										Map<String, String> querys,
//    										Map<String, String> bodys,
//                                            List<String> signHeaderPrefixList,
//                                            boolean lowcaseCompatible) {
//        StringBuilder sb = new StringBuilder();
//
//        sb.append(method.toUpperCase()).append(Constants.LF);
//        if (null != headers) {
//        	if (null != headers.get(HttpHeader.HTTP_HEADER_ACCEPT)) {
//                sb.append(headers.get(HttpHeader.HTTP_HEADER_ACCEPT));
//            }
//        	sb.append(Constants.LF);
//        	if (null != headers.get(HttpHeader.HTTP_HEADER_CONTENT_MD5)) {
//                sb.append(headers.get(HttpHeader.HTTP_HEADER_CONTENT_MD5));
//            }
//            sb.append(Constants.LF);
//            if (null != headers.get(HttpHeader.HTTP_HEADER_CONTENT_TYPE)) {
//                sb.append(headers.get(HttpHeader.HTTP_HEADER_CONTENT_TYPE));
//            }
//            sb.append(Constants.LF);
//            if (null != headers.get(HttpHeader.HTTP_HEADER_DATE)) {
//                sb.append(headers.get(HttpHeader.HTTP_HEADER_DATE));
//            }
//        }
//        sb.append(Constants.LF);
//        sb.append(buildHeaders(headers, signHeaderPrefixList, lowcaseCompatible));
//        sb.append(buildResource(path, querys, bodys));
//
//        // trace info
//        SIGN_STRING.set(sb.toString());
//
//        return sb.toString();
//    }
//
//    /**
//     * 构建待签名Path+Query+BODY
//     *
//     * @param path
//     * @param querys
//     * @param bodys
//     * @return 待签名
//     */
//    private static String buildResource(String path, Map<String, String> querys, Map<String, String> bodys) {
//    	StringBuilder sb = new StringBuilder();
//
//    	if (!StringUtils.isBlank(path)) {
//    		sb.append(path);
//        }
//        Map<String, String> sortMap = new TreeMap<String, String>();
//        if (null != querys) {
//        	for (Map.Entry<String, String> query : querys.entrySet()) {
//        		if (!StringUtils.isBlank(query.getKey())) {
//        			sortMap.put(query.getKey(), query.getValue());
//                }
//        	}
//        }
//
//        if (null != bodys) {
//        	for (Map.Entry<String, String> body : bodys.entrySet()) {
//        		if (!StringUtils.isBlank(body.getKey())) {
//        			sortMap.put(body.getKey(), body.getValue());
//                }
//        	}
//        }
//
//        StringBuilder sbParam = new StringBuilder();
//        for (Map.Entry<String, String> item : sortMap.entrySet()) {
//    		if (!StringUtils.isBlank(item.getKey())) {
//    			if (0 < sbParam.length()) {
//    				sbParam.append(Constants.SPE3);
//    			}
//    			sbParam.append(item.getKey());
//    			if (!StringUtils.isBlank(item.getValue())) {
//    				sbParam.append(Constants.SPE4).append(item.getValue());
//    			}
//            }
//    	}
//        if (0 < sbParam.length()) {
//        	sb.append(Constants.SPE5);
//        	sb.append(sbParam);
//        }
//
//        return sb.toString();
//    }
//
//    /**
//     * 构建待签名Http头
//     *
//     * @param headers 请求中所有的Http头
//     * @param signHeaderPrefixList 自定义参与签名Header前缀
//     * @return 待签名Http头
//     */
//    private static String buildHeaders(Map<String, String> headers, List<String> signHeaderPrefixList, boolean lowcaseCompatible) {
//    	StringBuilder sb = new StringBuilder();
//
//    	if (null != signHeaderPrefixList) {
//    		signHeaderPrefixList.remove(SystemHeader.X_CA_SIGNATURE);
//    		signHeaderPrefixList.remove(HttpHeader.HTTP_HEADER_ACCEPT);
//    		signHeaderPrefixList.remove(HttpHeader.HTTP_HEADER_CONTENT_MD5);
//    		signHeaderPrefixList.remove(HttpHeader.HTTP_HEADER_CONTENT_TYPE);
//    		signHeaderPrefixList.remove(HttpHeader.HTTP_HEADER_DATE);
//
//    		String version = headers.get(SignItemKey.API_VERSION_HEADER_KEY);
////    		boolean lowcaseCompatible = SignItemKey.lowcaseCompatibleVersion(version);
//    		// 兼容小写命名
//    		if (lowcaseCompatible) {
//        		signHeaderPrefixList.remove(SystemHeader.X_CA_SIGNATURE.toLowerCase());
//        		signHeaderPrefixList.remove(HttpHeader.HTTP_HEADER_ACCEPT.toLowerCase());
//        		signHeaderPrefixList.remove(HttpHeader.HTTP_HEADER_CONTENT_MD5.toLowerCase());
//        		signHeaderPrefixList.remove(HttpHeader.HTTP_HEADER_CONTENT_TYPE.toLowerCase());
//        		signHeaderPrefixList.remove(HttpHeader.HTTP_HEADER_DATE.toLowerCase());
//    		}
//
//    		Collections.sort(signHeaderPrefixList);
//    		if (null != headers) {
//    			boolean systemHeader = false;
//    			boolean extHeader = false;
//    			String key = null;
//
//    			Map<String, String> sortMap = new TreeMap<String, String>();
//    			for (Map.Entry<String, String> header : headers.entrySet()) {
//    				key = header.getKey();
//    				if (lowcaseCompatible && isHeaderToSign(header.getKey(), lowcaseCompatible)) {
//    					key = key.toLowerCase();
//    				}
//    				sortMap.put(key, header.getValue());
//    			}
//
//    			StringBuilder signHeadersStringBuilder = new StringBuilder();
//    			for (Map.Entry<String, String> header : sortMap.entrySet()) {
//    				systemHeader = isHeaderToSign(header.getKey(), lowcaseCompatible);
//    				extHeader = isExtHeaderToSign(header.getKey(), signHeaderPrefixList);
//
//                    if (systemHeader || extHeader) {
//                    	sb.append(header.getKey());
//                    	sb.append(Constants.SPE2);
//                        if (!StringUtils.isBlank(header.getValue())) {
//                        	sb.append(header.getValue());
//                        }
//                        sb.append(Constants.LF);
//                        if (0 < signHeadersStringBuilder.length()) {
//                        	signHeadersStringBuilder.append(Constants.SPE1);
//                        }
//                        signHeadersStringBuilder.append(header.getKey());
//                    }
//                }
//    			headers.put(SystemHeader.X_CA_SIGNATURE_HEADERS, signHeadersStringBuilder.toString());
//    		}
//    	}
//
//        return sb.toString();
//    }
//
//    /**
//     * Http头是否参与签名 return
//     */
//    private static boolean isHeaderToSign(String headerName, boolean lowcaseCompatible) {
//        if (StringUtils.isBlank(headerName)) {
//            return false;
//        }
//
//        if (headerName.startsWith(Constants.CA_HEADER_TO_SIGN_PREFIX_SYSTEM)) {
//            return true;
//        }
//
//        if (lowcaseCompatible && headerName.startsWith(Constants.CA_HEADER_TO_SIGN_PREFIX_SYSTEM.toLowerCase())) {
//        	return true;
//        }
//        return false;
//    }
//
//    /**
//     * 是否是参与签名的自定义消息头
//     */
//    private static boolean isExtHeaderToSign(String headerName, List<String> signHeaderPrefixList) {
//    	if (StringUtils.isBlank(headerName)) {
//            return false;
//        }
//    	 if (null != signHeaderPrefixList) {
//             for (String signHeaderPrefix : signHeaderPrefixList) {
//                 if (headerName.equalsIgnoreCase(signHeaderPrefix)) {
//                     return true;
//                 }
//             }
//         }
//    	 return false;
//    }
//}