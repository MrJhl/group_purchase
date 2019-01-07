package com.group.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Shop;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdminVo {
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Integer gender;

    private String realName;

    private Integer userStatus;

    private Integer userType;

    private Shop shop;

    private Date createTime;

    private Date lastEditTime;
}
