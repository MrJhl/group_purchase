package com.group.shop.mapper;

import com.group.shop.entity.UserShop;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserShopMapper {

    int insertUserShop(UserShop userShop);

    int insertSelective(UserShop userShop);

}