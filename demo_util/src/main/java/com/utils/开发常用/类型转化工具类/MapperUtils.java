package com.utils.开发常用.类型转化工具类;

import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 深度复制映射转换辅助类
 *
 * @author flydoos
 * @date 2019/4/3
 */
public final class MapperUtils {
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


    /**
     * 将Map转成对象
     * @param map Map
     * @param beanClass 对象
     * @return 对象
     * @throws Exception 异常
     */
    public static Object mapToObject(Map<String, String> map,Class<?> beanClass) throws Exception {
        if (map == null) {
            return null;
        }
        Object obj = beanClass.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) {
                setter.invoke(obj, map.get(property.getName()));
            }
        }
        return obj;
    }


    /**
     * 将对象转Map
     * @param object 对象
     * @return Map
     */
    public static Map<String, Object> objectToMap(Object object) {
        Map<String, Object> map = new HashMap<>();

        //获取f对象对应类中的所有属性域
        Field[] fields = object.getClass().getDeclaredFields();
        if (fields.length>0){
            for (Field field : fields) {
                String varName = field.getName();
                //将key置为小写,默认为对象的属性
                varName = varName.toLowerCase();
                try {
                    // 获取原来的访问控制权限
                    boolean accessFlag = field.isAccessible();
                    // 修改访问控制权限
                    field.setAccessible( true );
                    // 获取在对象中属性fields[i]对应的对象中的变量
                    Object o = field.get( object );
                    if (o != null) {
                        map.put( varName,o );
                    }
                    field.setAccessible( accessFlag );
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return map;
    }


    /**
     * HahMap 转化 LinkedHashMap (实现Map按照添加顺序排列)
     * @param map
     * @return
     */
    public static Map<String,Object> sortHashMap(Map<String, List<Object>> map){
        Map<String,Object> sortedMap = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        Iterator<String> item = map.keySet().iterator();
        while(item.hasNext()){
            list.add(item.next());
        }
        Collections.sort(list);
        Iterator<String> item2 = list.iterator();
        while(item2.hasNext()){
            String key = item2.next();
            sortedMap.put(key,map.get(key));
        }
        return sortedMap;
    }


}
