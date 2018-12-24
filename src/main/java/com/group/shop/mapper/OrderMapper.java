package com.group.shop.mapper;

import com.group.shop.entity.Order;

import java.util.List;

import com.group.shop.vo.OrderVo;
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

    /**
     * 获取订单列表
     * @param orderVo
     * @return
     */
    List<OrderVo> getOrderVoList(OrderVo orderVo);
}