package com.group.shop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Order {
    private String number;

    private Integer goodsId;

    private Integer userId;

    private Integer shopId;

    private Integer total;

    private Integer status;

    private String remark;

    private Date createTime;

    private Date lastEditTime;

}