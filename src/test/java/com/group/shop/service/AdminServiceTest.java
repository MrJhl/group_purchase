package com.group.shop.service;

import com.group.shop.ShopApplicationTests;
import com.group.shop.entity.Admin;
import com.group.shop.mapper.AdminMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminServiceTest extends ShopApplicationTests {

    @Autowired
    private AdminService adminService;

    @Test
    public void testInsert(){
        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.setGender(1);
        admin.setEmail("1240364839@qq.com");
        admin.setPhone("13813999999");
        admin.setRealName("管理员");
        admin.setUserType(0);
        admin.setPassword("123456");
        int num = adminService.insertAdmin(admin);
        System.out.println(num);
    }

}
