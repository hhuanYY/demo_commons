package com.utils.api.controller;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/6/6
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DemoExcelCopy {
    @ExcelProperty(value = "姓名", order = 1)
    private String username;
    @ExcelProperty(value = "年龄", order = 2)
    private Integer age;

    private String address;

}
