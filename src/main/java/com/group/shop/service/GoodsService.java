package com.group.shop.service;

import com.group.shop.entity.Goods;
import com.group.shop.vo.GoodsInfo;

public interface GoodsService {

	Goods queryById(Integer id);
	
	Boolean insertGoodsByGoods(Goods goods);
	
	Boolean insertSelective(GoodsInfo record);
	
	Boolean updateByPrimarykeySelective(Goods goods);
	
	Boolean updateGoods(Goods goods);
	
	Boolean deleteById(Integer id);
}
