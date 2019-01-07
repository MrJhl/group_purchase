package com.group.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.Shop;
import com.group.shop.mapper.ShopMapper;
import com.group.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public PageInfo<Shop> limitShop(Shop shop, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Shop> shopList;
        try {
            shopList = shopMapper.getShopList(shop);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
        }
        return new PageInfo<>(shopList);
    }
}
