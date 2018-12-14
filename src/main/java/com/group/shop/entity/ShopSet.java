package com.group.shop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ShopSet {
    private Integer shopId;

    private Integer setId;

}