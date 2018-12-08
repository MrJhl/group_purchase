package com.group.shop.service;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.shop.ShopApplicationTests;
import com.group.shop.config.webconfig.MyWebAppConfigurer;
import com.group.shop.mapper.MediaMapper;


public class SetServiceTest extends ShopApplicationTests{

	@Autowired
	private MediaMapper mediaMapper;
	@Test
	public void testInsert() {
		System.out.println("####"+mediaMapper.queryById(1));
		System.out.println("####"+mediaMapper.queryById(1));
	}
	
}
