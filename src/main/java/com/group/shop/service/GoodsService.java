package com.group.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.group.shop.entity.Goods;
import com.group.shop.vo.GoodsInfo;
import com.group.shop.vo.GoodsUrl;

public interface GoodsService {

	Goods queryById(Integer id);
	
	Boolean insertGoodsByGoods(Goods goods);
	
	Boolean insertSelective(GoodsInfo record);
	
	Boolean updateByPrimarykeySelective(Goods goods);
	
	Boolean updateGoods(Goods goods);
	
	Boolean deleteById(Integer id);
	
	List<GoodsUrl> querySetInfoAndImgById(Integer id);

	/**
	 * 分页查询
	 * @param goods
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
    PageInfo<Goods> limitGoods(Goods goods, Integer pageSize, Integer pageIndex);
}
