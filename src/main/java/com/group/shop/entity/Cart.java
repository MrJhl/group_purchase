package com.group.shop.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Cart {
    private Integer id;

    private Integer goodsId;

    private Integer userId;

    private Integer total;

    private Date createTime;

    private Date lastEditTime;

   
}