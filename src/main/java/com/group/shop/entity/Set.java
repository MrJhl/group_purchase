package com.group.shop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Set {
    private Integer id;

    private String name;

    private String describe;

    private Float salePrice;

    private Float price;

    private Integer total;

    private Integer index;
    
    private Date createTime;

    private Date lastEditTime;


}