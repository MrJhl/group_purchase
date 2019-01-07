package com.group.shop.service;

import com.github.pagehelper.PageInfo;
import com.group.shop.entity.Admin;
import com.group.shop.vo.AdminVo;
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

    /**
     * 插入管理员
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);

    /**
     * 更新管理员
     * @param admin
     * @return
     */
    int updateAdmin(Admin admin);

    /**
     * 删除管理员
     * @param id
     * @return
     */
    int deleteAdmin(Integer id);

    /**
     * 分页
     * @param admin
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<AdminVo> limitAdmin(Admin admin, Integer pageIndex, Integer pageSize);
}
