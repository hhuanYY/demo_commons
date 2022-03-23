package com.utils.字符串相关;

import org.apache.commons.lang3.StringUtils;

/**
 * @author: yuanyinhuan
 * @date: 2022/1/5 11:43
 */
public class IsBlankDemo {
    public static void main(String[] args) {

        /**
         *     isBlank源代码:
         *     public static boolean isBlank(CharSequence cs) {
         *         int strLen = length(cs);
         *         if (strLen == 0) {
         *             return true;
         *         } else {
         *             for(int i = 0; i < strLen; ++i) {
         *                 if (!Character.isWhitespace(cs.charAt(i))) {
         *                     return false;
         *                 }
         *             }
         *
         *             return true;
         *         }
         *     }
         *
         *      StringUtils.isBlank(null)           =true
         *      StringUtils.isBlank("")             =true
         *      StringUtils.isBlank(" ")            =true
         *      StringUtils.isBlank("bob")          =false
         *      StringUtils.isBlank("   bob  ")     =false
         */

        /*调用isBlank,传入字符串null后, 返回false StringUtils.isBlank()将其视为String而不是null对象,并且您将获得“ false”布尔值 */
        StringUtils.isBlank("null");
    }
}
