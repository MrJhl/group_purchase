package com.group.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Goods;
import com.group.shop.entity.Order;
import com.group.shop.entity.Shop;
import com.group.shop.entity.User;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderVo {

    private Shop shop;

    private Goods goods;

    private User user;

    private String number;

    private Integer total;

    private Integer status;

    private String remark;

    private Date createTime;

    private Date lastEditTime;
}
