package com.group.shop.mapper;

import com.group.shop.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {

    int deleteById(Integer id);

    int insertGoods(Goods goods);

    int insertSelective(Goods record);

    Goods queryById(Integer id);

    int updateByPrimaryKeySelective(Goods goods);

    int updateGoods(Goods goods);
}