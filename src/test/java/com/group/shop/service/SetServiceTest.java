package com.group.shop.service;



import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.group.shop.ShopApplicationTests;
import com.group.shop.config.webconfig.MyWebAppConfigurer;
import com.group.shop.mapper.MediaMapper;
import com.group.shop.mapper.SetMapper;
import com.group.shop.vo.SetUrl;


public class SetServiceTest extends ShopApplicationTests{

	@Autowired
	private MediaMapper mediaMapper;
	@Autowired
	private SetMapper setMapper;
	@Test
	public void testInsert() {
		List<SetUrl> setUrl = setMapper.querySetInfoAndImgById(1);
		System.out.println("#### "+setUrl+" ####");
		System.out.println("####"+mediaMapper.queryById(1));
		System.out.println("####"+mediaMapper.queryById(1));
	}
	
}
