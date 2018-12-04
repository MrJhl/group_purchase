package com.group.shop.controller;

import com.group.shop.common.CodeMsg;
import com.group.shop.common.Result;
import com.group.shop.entity.Admin;
import com.group.shop.service.AdminService;
import com.group.shop.vo.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 后台系统登录
     * @param admin
     * @return
     */
    @PostMapping(value = "/login",produces = {"application/json;charset=UTF-8"})
    public Result<Object> loginSystem(@RequestBody Admin admin){
        LoginInfo loginInfo = adminService.login(admin);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }else{
            return Result.errorMsg("登录失败，不存在该用户/密码错误/未审核通过！");
        }
    }

    /**
     * token登录
     * @param token
     * @return
     */
    @GetMapping(value = "/tokenlogin",produces = {"application/json;charset=UTF-8"})
    public Result<Boolean> tokenLogin(@RequestParam(name = "token",required = true)String token){
        boolean isLogin = adminService.TokenLogin(token);
        if(isLogin){
            return Result.success(true);
        }else{
            return Result.error(CodeMsg.FAIL);
        }
    }
}
