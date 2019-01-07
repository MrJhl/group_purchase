package com.group.shop.service;

import com.group.shop.ShopApplicationTests;
import com.group.shop.entity.Shop;
import com.group.shop.mapper.ShopMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopServiceTest extends ShopApplicationTests {

    @Autowired
    private ShopMapper shopMapper;

    @Test
    public void testQuery(){
        Shop shop = shopMapper.queryById(1);
        System.out.println(shop.getName());
    }
}
