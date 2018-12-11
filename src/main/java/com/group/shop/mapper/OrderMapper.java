package com.group.shop.mapper;

import com.group.shop.entity.Order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int deleteByNumber(String number);

    int insertOrder(Order order);

    int insertSelective(Order order);

    Order queryByNumber(String number);

    int updateByPrimaryKeySelective(Order order);

    int updateOrder(Order order);
    
    List<Order> queryByUserId(Integer id);
}