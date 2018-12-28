package com.group.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.shop.ShopApplicationTests;
import com.group.shop.entity.Cart;
import com.group.shop.mapper.CartMapper;

public class CarTest extends ShopApplicationTests{

	@Autowired
	private CartMapper cartMapper;
	
	@Test
	public void CarTest() {
		List<Cart> carts = new ArrayList<>();
		Cart car = new Cart();
		car.setId(4);
		car.setTotal(6);
		carts.add(car);
		Boolean num = cartMapper.insertOrUpdateList(carts);
		System.out.println("#### "+num+" ####");
	}
	
}
