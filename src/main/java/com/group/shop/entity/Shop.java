package com.group.shop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Shop {
    private Integer id;

    private String name;

    private String num;

    private String address;

    private String phone;

    private String email;

    private Date createTime;

    private Date lastEditTime;


}