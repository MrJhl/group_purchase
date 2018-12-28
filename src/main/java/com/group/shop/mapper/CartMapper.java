package com.group.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.group.shop.entity.Cart;

import io.lettuce.core.dynamic.annotation.Param;

@Mapper
public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
    
    Boolean insertOrUpdateList(@Param("record") List<Cart> record);
}