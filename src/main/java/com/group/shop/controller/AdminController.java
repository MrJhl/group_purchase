package com.group.shop.controller;

import com.github.pagehelper.PageInfo;
import com.group.shop.common.CodeMsg;
import com.group.shop.common.Result;
import com.group.shop.entity.Admin;
import com.group.shop.service.AdminService;
import com.group.shop.vo.AdminVo;
import com.group.shop.vo.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 分页查询
     * @param name
     * @param pageIndex
     * @param shopId
     * @return
     */
    @GetMapping(value = "/limit",produces = {"application/json;charset=UTF-8"})
    public Result<Object> limitAdmin(@RequestParam(name = "name",required = false)String name,
                                     @RequestParam(name = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                                     @RequestParam(name = "pageSize",required = false,defaultValue = "20")Integer pageSize,
                                     @RequestParam(name = "shopId",required = false)Integer shopId){
        Admin admin = new Admin();
        admin.setUsername(name);
        admin.setShopId(shopId);
        PageInfo<AdminVo> pageInfo = adminService.limitAdmin(admin,pageIndex,pageSize);

        if(pageInfo.getTotal() > 0){
            Map<String,Object> map = new HashMap<>();
            map.put("total",pageInfo.getTotal());
            map.put("data",pageInfo.getList());
            return Result.success(map);
        }else{
            return Result.errorMsg("没有管理人员信息！");
        }
    }
}
