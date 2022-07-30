package com.utils.开发常用.递归;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.utils.开发常用.递归.entity.DataResult;
import com.utils.开发常用.递归.entity.Organization;
import com.utils.开发常用.递归.entity.OrganizationTreeEnum;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 递归实现树结构响应
 */
public class TreeByRecursionDemo {
    public static void main(String[] args) {
        List<Organization> organizationList = new ArrayList<>();
        organizationList.add(new Organization("1", "商旅事业部", "12", "广州大区", "123", "白云区域", "1234", "白云城市便捷"));
        organizationList.add(new Organization("1", "商旅事业部", "12", "广州大区", "123", "白云区域", "1243", "人和城市便捷"));
        organizationList.add(new Organization("2", "中高端事业部", "23", "湖北大区", "234", "武汉区域", "2345", "武汉城市便捷"));
        organizationList.add(new Organization("2", "中高端事业部", "23", "湖北大区", "234", "武汉区域", "2354", "汉口城市便捷"));
        organizationList.add(new Organization("3", "华东公司", "34", "荆州大区", "345", "长江区域", "3456", "长江城市便捷"));
        organizationList.add(new Organization("3", "华东公司", "34", "荆州大区", "345", "长江区域", "3465", "文理城市便捷"));

        List<JSONObject> list = organizationList.stream().map(org -> JSON.parseObject(JSON.toJSONString(org))).collect(Collectors.toList());

        List<DataResult> dataResultList = new ArrayList<>();
        dataResultList.add(new DataResult("1", "商旅事业部", "THEATER", null));

        for (DataResult dataResult : dataResultList) {
            treeListByRecursion(dataResult, list);
        }
        System.out.println(dataResultList);

    }


    private static void treeListByRecursion(DataResult dataResult, List<JSONObject> list) {
        OrganizationTreeEnum organizationTreeEnum = OrganizationTreeEnum.valueOf(dataResult.getOrganizationType());
        if (OrganizationTreeEnum.SHOP.equals(organizationTreeEnum)) {
            return;
        }

        List<DataResult> next = organizationTreeEnum.next(dataResult.getOrganizationId(), list);
        if (CollectionUtils.isNotEmpty(next)) {
            dataResult.setChildrenList(next);
            for (DataResult node : next) {
                treeListByRecursion(node, list);
            }
        }


    }






    /**
     * 递归方法实现寻找组织架构层级
     * @param dataResult 层级对象
     * @param list 组织架构完整列表
     */
//    public static void treeListByRecursion(DataResult dataResult, List<JSONObject> list) {
//        OrganizationTreeEnum organizationEnum = OrganizationTreeEnum.valueOf(dataResult.getOrganizationType());
//        if (OrganizationTreeEnum.SHOP.equals(organizationEnum)) {
//            return;
//        }
//        List<DataResult> next = organizationEnum.next(dataResult.getOrganizationId(), list);
//        dataResult.setChildrenList(next);
//        if (CollectionUtils.isNotEmpty(next)) {
//            for (DataResult node : next) {
//                treeListByRecursion(node, list);
//            }
//        }
//
//    }

}

