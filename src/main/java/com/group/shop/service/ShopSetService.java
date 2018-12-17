package com.group.shop.service;

import com.github.pagehelper.PageInfo;
import com.group.shop.entity.ShopSet;
import com.group.shop.vo.ShopSetVo;

public interface ShopSetService {

    /**
     * 分页查询
     * @param shopSet
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<ShopSetVo> limitShopSet(ShopSet shopSet, Integer pageIndex, Integer pageSize);
}
