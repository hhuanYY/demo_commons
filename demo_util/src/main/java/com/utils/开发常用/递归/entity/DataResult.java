package com.utils.开发常用.递归.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataResult {
    private String organizationId;
    private String organizationName;
    private String organizationType;
    private List<DataResult> childrenList;
}
