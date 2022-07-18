package com.utils.日常api.校验参数是否有注入;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: yuanyinhuan
 * @date: 2022/2/16 15:04
 */
public class CheckOutSql {
    /**
     * 校验参数是否有注入危险
     * @param params 参数
     * @return 校验结果
     */
    private boolean checkSqlInjection(String params) {
        String regex = ("\\s+or\\s+|\\s+;\\s+|\\s+drop\\s+|\\s+grant\\s+|\\s+--|\\s+union\\s+|\\s+delete\\s+|\\s+truncate\\s+");
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(params);
        return m.find();
    }
}
