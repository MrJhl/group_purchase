package com.group.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.shop.entity.Cart;
import com.group.shop.mapper.CartMapper;
import com.group.shop.service.CartService;

@Service("CartService")
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;

	@Override
	public Boolean deleteByPrimaryKey(Integer id) {
		return cartMapper.deleteByPrimaryKey(id) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean insert(Cart record) {
		return cartMapper.insert(record) ==1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean insertSelective(Cart record) {
		return cartMapper.insertSelective(record) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Cart selectByPrimaryKey(Integer id) {
		return cartMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean updateByPrimaryKeySelective(Cart record) {
		return cartMapper.updateByPrimaryKeySelective(record) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean updateByPrimaryKey(Cart record) {
		return cartMapper.updateByPrimaryKey(record) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean insertOrUpdateList(List<Cart> record) {
		return cartMapper.insertOrUpdateList(record);
	}
	
	

}
