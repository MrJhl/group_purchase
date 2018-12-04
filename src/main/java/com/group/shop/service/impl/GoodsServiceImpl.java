package com.group.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.shop.entity.Goods;
import com.group.shop.mapper.GoodsMapper;
import com.group.shop.service.GoodsService;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public Goods queryById(Integer id) {
		return goodsMapper.queryById(id);
	}

	@Override
	public Boolean insertGoodsByGoods(Goods goods) {
		
		return goodsMapper.insertGoods(goods) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean insertSelective(Goods record) {
		return goodsMapper.insertSelective(record) ==1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean updateByPrimarykeySelective(Goods goods) {
		return goodsMapper.updateByPrimaryKeySelective(goods) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean updateGoods(Goods goods) {
		return goodsMapper.updateGoods(goods) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean deleteById(Integer id) {
		return goodsMapper.deleteById(id) ==1 ? Boolean.TRUE : Boolean.FALSE;
	}


}
