package com.group.shop.mapper;

import com.group.shop.entity.Shop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopMapper {

    int deleteById(Integer id);

    int insertShop(Shop shop);

    int insertSelective(Shop shop);

    Shop queryById(Integer id);

    int updateShop(Shop shop);
}