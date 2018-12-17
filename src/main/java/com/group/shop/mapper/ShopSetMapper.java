package com.group.shop.mapper;

import com.group.shop.vo.ShopSetVo;
import org.apache.ibatis.annotations.Mapper;

import com.group.shop.entity.ShopSet;

import java.util.List;

@Mapper
public interface ShopSetMapper {
    int insert(ShopSet record);

    int insertSelective(ShopSet record);

    /**
     * 获取套餐信息
     * @param shopSet
     * @return
     */
    List<ShopSetVo> getShopSetVoList(ShopSet shopSet);
}