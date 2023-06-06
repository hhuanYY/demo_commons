package com.utils.api.controller;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/6/6
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoExcel {
    @ExcelProperty(value = "姓名", order = 1)
    private String username;
    @ExcelProperty(value = "年龄", order = 2)
    private Integer age;
}
