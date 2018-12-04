package com.group.shop.mapper;

import com.group.shop.entity.GoodsOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsOrderMapper {

    int insertGoodsOrder(GoodsOrder goodsOrder);

    int insertSelective(GoodsOrder goodsOrder);

}