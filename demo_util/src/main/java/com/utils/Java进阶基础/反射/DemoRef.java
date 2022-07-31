package com.utils.Java进阶基础.反射;

import com.utils.Java进阶基础.DemoAnnotation;
import lombok.Data;

@Data
@DemoAnnotation(value = "DemoRef.cls")
public class DemoRef {
    private String name;

    public DemoRef(String name) {
        this.name = name;
    }
}
