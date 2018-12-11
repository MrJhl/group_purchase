package com.group.shop.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.group.shop.entity.ShopSet;

@Mapper
public interface ShopSetMapper {
    int insert(ShopSet record);

    int insertSelective(ShopSet record);
}