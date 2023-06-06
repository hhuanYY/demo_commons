package 防止表单重复提交.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import 防止表单重复提交.RepeatSubmit;
import 防止表单重复提交.RepeatSubmitInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
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
public class CheckSubmitInterceptor extends RepeatSubmitInterceptor {

    public static final String REQUEST_PARAMS = "requestParams";
    public static final String REQUEST_DATE = "requestDate";
    public static final String REQUEST_JSON = "requestJson";

    @Override
    public Boolean checkIsOrNotSubmit(HttpServletRequest request, RepeatSubmit repeatSubmit, String methodName) {
        // 将信息保存到session中，每次请求先根据请求路径去session中找，如果找到了则判断请求参数和请求时间是否大于设置的请求间隔时间
        Map<String, Object> nowMap = new HashMap<>();
        nowMap.put(REQUEST_PARAMS, JSON.toJSONString(request.getParameterMap()));
        nowMap.put(REQUEST_DATE, Instant.now().toEpochMilli());

        final String sessionKey = REQUEST_JSON + "-" + methodName;

        String requestURI = request.getRequestURI();

        // 每个客户端对应的session都是独立的
        HttpSession session = request.getSession();

        // 根据key拿到value
        Object resultMap = session.getAttribute(sessionKey);
        if (Objects.nonNull(resultMap)) {
            // 判断请求参数和请求间隔时间
            Map<String, Object> dataMap = (Map<String, Object>) resultMap;
            if (dataMap.containsKey(requestURI)) {
                Map<String, Object> preMap = (Map<String, Object>) dataMap.get(requestURI);
                return checkParamsAndDateTime(nowMap, preMap,repeatSubmit.interval());
            }
        }

        // 没有从session中拿到数据,表明是第一次请求 将数据存到session
        Map<String, Object> result = new HashMap<>();
        result.put(requestURI, nowMap);
        session.setAttribute(sessionKey, result);
        return false;
    }

    /**
     * 检查请求参数和间隔时间
     * @param nowMap 当前请求Map
     * @param preMap 历史请求Map
     * @param interval 间隔时间
     * @return 是否重复提交
     */
    private Boolean checkParamsAndDateTime(Map<String, Object> nowMap, Map<String, Object> preMap,int interval) {
        String nowParams = (String) nowMap.get(REQUEST_PARAMS);
        String preParams = (String) preMap.get(REQUEST_PARAMS);
        Long nowDate = (Long) nowMap.get(REQUEST_DATE);
        Long preDate = (Long) preMap.get(REQUEST_DATE);
        return nowParams.equalsIgnoreCase(preParams) && (nowDate - preDate) <= interval;
    }

}
