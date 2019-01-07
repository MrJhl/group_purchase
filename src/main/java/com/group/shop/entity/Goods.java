package com.group.shop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Goods {
    private Integer id;

    private String name;

    private String describe;

    private String standard;
    
    private Float salePrice;
    
    private Integer setId;

    private String photo;

    private Date createTime;

    private Date lastEditTime;

 
}