package com.group.shop.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.shop.ShopApplicationTests;
import com.group.shop.entity.User;

public class UserServiceTest extends ShopApplicationTests{

	@Autowired
	private UserService userService;
	
	@Test
	public void addUserTest() {
		User user = new User();
		user.setOpenId("123456");
		user.setUsername("tom2");
		int flag = userService.insertUser(user);
		System.out.println("####: "+flag);
	}
	
}
