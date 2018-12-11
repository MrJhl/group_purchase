package com.group.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.Order;
import com.group.shop.mapper.OrderMapper;
import com.group.shop.service.OrderService;

@Service("OrderService")
public class OrderServiceImpl implements OrderService {
	
	Logger log = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public int deleteByNumber(String number) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Boolean insertOrder(Order order) {
		order.setCreateTime(new Date());
		order.setLastEditTime(new Date());
		try {
			return orderMapper.insertOrder(order)==1?Boolean.TRUE:Boolean.FALSE;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
		
	}

	@Override
	public int insertSelective(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order queryByNumber(String number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateByPrimaryKeySelective(Order order) {
		order.setLastEditTime(new Date());
		try {
			return orderMapper.updateByPrimaryKeySelective(order)==1?Boolean.TRUE:Boolean.FALSE;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
	}

	@Override
	public int updateOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> queryByUserId(Integer id) {
		try {
			return orderMapper.queryByUserId(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
	}

}
