package com.group.shop.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Banner {
    private Integer id;

    private Integer index;

    private String name;

    private String url;

    private Date createTime;

    private Date lastEditTime;

 
}