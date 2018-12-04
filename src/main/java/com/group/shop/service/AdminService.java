package com.group.shop.service;

import com.group.shop.entity.Admin;
import com.group.shop.vo.LoginInfo;

public interface AdminService {

    /**
     * 登录系统
     * @param admin
     * @return
     */
    LoginInfo login(Admin admin);

    /**
     * 检验token失效与否
     * @param token
     * @return
     */
    boolean TokenLogin(String token);
}
