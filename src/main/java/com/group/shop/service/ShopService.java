package com.group.shop.service;

import com.github.pagehelper.PageInfo;
import com.group.shop.entity.Shop;

public interface ShopService {

    /**
     * 分页查询
     * @param shop
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<Shop> limitShop(Shop shop, Integer pageIndex, Integer pageSize);
}
