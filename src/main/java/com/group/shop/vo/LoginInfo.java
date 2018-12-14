package com.group.shop.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Goods;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class LoginInfo {

    private Integer id;

    private String username;

    private String token;

    private String phone;

    private String email;

    private Integer gender;

    private String realName;


}
