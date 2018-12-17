package com.group.shop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopSet {
    private Date startTime;

    private Date endTime;

    private Integer shopId;

    private Integer setId;
}