package com.utils.反射;

import com.utils.annotation.TestAnnotation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/4/15 15:26
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
//    private String userName;
//
//    private Integer age;
//
//    private String email;

    @TestAnnotation(isIndex = true,indexType = "GMV")
    private BigDecimal gmv;

    @TestAnnotation(isIndex = true, indexType = "OCC")
    private BigDecimal occ;

    @TestAnnotation(isIndex = true, indexType = "ADR")
    private BigDecimal adr;

}
