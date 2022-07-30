package com.utils.开发常用.递归.entity;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum OrganizationTreeEnum {

    THEATER("theaterId", "branchId", "branchName", "BRANCH"),
    BRANCH("branchId", "regionId", "regionName", "REGION"),
    REGION("regionId", "hotelId", "hotelName", "SHOP"),
    SHOP("hotelId", null, null, null),
    ;

    OrganizationTreeEnum(String field, String nextField, String nextName, String nextType) {
        this.field = field;
        this.nextField = nextField;
        this.nextName = nextName;
        this.nextType = nextType;
    }

    private final String field;
    private final String nextField;
    private final String nextName;
    private final String nextType;


    public List<DataResult> next(String id,List<JSONObject> organizationList){
        List<JSONObject> collect = organizationList.stream().filter(org -> id.equals(org.getString(this.field))).collect(Collectors.toList());

        Map<String, DataResult> map = new HashMap<>();
        collect.forEach(i ->{
            DataResult dataResult = new DataResult();
            dataResult.setOrganizationId(i.getString(this.nextField));
            dataResult.setOrganizationName(i.getString(this.nextName));
            dataResult.setOrganizationType(this.nextType);
            map.put(dataResult.getOrganizationId(),dataResult);
        });
        return new ArrayList<>(map.values());
    }

}
