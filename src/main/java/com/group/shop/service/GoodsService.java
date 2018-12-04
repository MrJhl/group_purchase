package com.group.shop.service;

import com.group.shop.entity.Goods;

public interface GoodsService {

	Goods queryById(Integer id);
	
	Boolean insertGoodsByGoods(Goods goods);
	
	Boolean insertSelective(Goods record);
	
	Boolean updateByPrimarykeySelective(Goods goods);
	
	Boolean updateGoods(Goods goods);
	
	Boolean deleteById(Integer id);
}
