package com.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 深度复制映射转换辅助类
 *
 * @author flydoos@vip.qq.com
 * @date 2020/4/22
 */
public class MapperUtils {
    /**
     * 普通对象转换 比如: ADO -> AVO
     *
     * @param: [source 源对象, targetClass 目标对象class]
     * @return: T
     */
    public static <T> T map(Object source, Class<T> targetClass) {
        T target = null;
        try {
            if (source == null) {
                target = null;
            } else {
                target = targetClass.newInstance();
                BeanUtils.copyProperties(source, target);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return target;
    }

    /**
     * List转换 比如: List<ADO> -> List<AVO>
     *
     * @param: [sourceList 源对象List, targetClass 目标对象class]
     * @return: java.util.List<T>
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> targetClass) {
        List<T> targetList = new ArrayList();
        try {
            if (sourceList == null) {
                targetList = new ArrayList();
            } else {
                for (Object source : sourceList) {
                    if (source != null) {
                        T target = targetClass.newInstance();
                        BeanUtils.copyProperties(source, target);
                        targetList.add(target);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetList;
    }
}
