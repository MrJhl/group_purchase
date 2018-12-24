package com.group.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.group.shop.entity.Order;
import com.group.shop.vo.OrderVo;

public interface OrderService {

    int deleteByNumber(String number);

    Boolean insertOrder(Order order);

    int insertSelective(Order order);

    Order queryByNumber(String number);

    Boolean updateByPrimaryKeySelective(Order order);

    int updateOrder(Order order);
    
    List<Order> queryByUserId(Integer id);

    /**
     * 分页查询
     * @param orderVo
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageInfo<OrderVo> limitOrderVo(OrderVo orderVo, Integer pageIndex, Integer pageSize);
}
