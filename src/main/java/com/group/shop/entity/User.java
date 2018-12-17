package com.group.shop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    private Integer id;

    private String openId;

    private String username;

    private Integer gender;

    private String phone;

    private String address;

    private String photo;

    private Date createTime;

    private Date lastEditTime;

}