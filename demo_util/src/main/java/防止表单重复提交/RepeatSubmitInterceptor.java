package 防止表单重复提交;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/5/17
 */
@Component
public abstract class RepeatSubmitInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断handler是否为HandlerMethod类型
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RepeatSubmit annotation = handlerMethod.getMethodAnnotation(RepeatSubmit.class);
            if (Objects.nonNull(annotation)) {
                // 判断请求参数以及提交时间
                String methodName = handlerMethod.getMethod().getName();
                if (this.checkIsOrNotSubmit(request, annotation,methodName)) {
                    // 重复提交,此时应该拦截处理器继续处理后面的任务。给出提示，直接返回
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public abstract Boolean checkIsOrNotSubmit(HttpServletRequest request, RepeatSubmit repeatSubmit, String methodName);

}
