package com.utils.开发常用.递归.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private String theaterId;
    private String theaterName;
    private String branchId;
    private String branchName;
    private String regionId;
    private String regionName;
    private String hotelId;
    private String hotelName;
}
