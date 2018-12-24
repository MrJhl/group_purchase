package com.group.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Set;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GoodsVo {

    private Integer id;

    private String name;

    private String describe;

    private String standard;

    private Float salePrice;

    private Set set;

    private Date createTime;

    private Date lastEditTime;
}
