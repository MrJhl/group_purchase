package com.group.shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.group.shop.entity.TbAdmin;
import com.group.shop.entity.TbGoods;
import com.group.shop.mapper.TbGoodsMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopApplicationTests {

	@Autowired
	private TbAdmin tbAdmin;
	
	@Before
	public void init() {
		System.out.println("测试开始--------------------------------------------");
	}
	
	@After
	public void after() {
		System.out.println("测试结束--------------------------------------------");
	}
	//测试商品接口
	@Test
	public void goodsTest() {
		//TbGoods goods = tbGoodsMapper.selectByPrimaryKey(1);
		System.out.println("#### "+" ####");
		
	}

}
