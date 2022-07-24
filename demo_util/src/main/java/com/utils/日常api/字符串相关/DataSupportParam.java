package com.utils.日常api.字符串相关;

import lombok.Data;

/**
 * @ProjectName：dossen-report-api
 * @ClassDesc：
 * @Author：yyhuan
 * @CreateTime：2022/5/7
 */
@Data
public class DataSupportParam {
    private String conditionName;

    private String conditionField;

    private String conditionValue;

    public DataSupportParam(String conditionName,String conditionField,String conditionValue) {
        this.conditionName = conditionName;
        this.conditionField = conditionField;
        this.conditionValue = conditionValue;
    }
}
