package com.group.shop.service;

import java.util.List;

import com.group.shop.entity.Cart;

import io.lettuce.core.dynamic.annotation.Param;

public interface CartService {

	Boolean deleteByPrimaryKey(Integer id);

    Boolean insert(Cart record);

    Boolean insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    Boolean updateByPrimaryKeySelective(Cart record);

    Boolean updateByPrimaryKey(Cart record);
    
    /**
     * 批量插入或更新
     * @param record
     * @return
     */
    Boolean insertOrUpdateList(@Param("record") List<Cart> record);
	
}
