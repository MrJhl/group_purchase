package com.group.shop.service;

import java.util.List;

import com.group.shop.entity.Order;

public interface OrderService {

    int deleteByNumber(String number);

    Boolean insertOrder(Order order);

    int insertSelective(Order order);

    Order queryByNumber(String number);

    Boolean updateByPrimaryKeySelective(Order order);

    int updateOrder(Order order);
    
    List<Order> queryByUserId(Integer id);
	
}
