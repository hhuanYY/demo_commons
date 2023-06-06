package 防止表单重复提交;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RepeatSubmit {
    int interval() default 5000;

    String message() default "重复提交,请稍后重试！";
}
