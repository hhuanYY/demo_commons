package com.utils.开发常用.泛型;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName GenericPojo
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/8/7 15:20
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericPojo {
    private Integer genericInteger;
    private String genericString;
}
