package com.utils.常用工具.输入日志模板;

import java.text.MessageFormat;

/**
 * @ClassName Desc
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/4/15 21:29
 * @Version 1.0
 */
public class Desc {
    private final DescEnum descEnum;

    public Desc(DescEnum descEnum) {
        this.descEnum = descEnum;
    }

    private String desc(String descStr,DescEnum descEnum){
        return MessageFormat.format(descStr, descEnum);
    }

    public String addDemo(){
        return desc("{0}失败！！！", descEnum);
    }

    public String updateDemo() {
        return desc("{0}失败！！！", descEnum);
    }


}
