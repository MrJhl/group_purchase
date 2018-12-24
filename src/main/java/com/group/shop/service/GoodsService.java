package com.group.shop.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.group.shop.entity.Goods;
import com.group.shop.re.GoodsRe;
import com.group.shop.vo.GoodsInfo;
import com.group.shop.vo.GoodsUrl;
import com.group.shop.vo.GoodsVo;

public interface GoodsService {

	Goods queryById(Integer id);
	
	Boolean insertGoodsByGoods(Goods goods);
	
	Boolean insertSelective(GoodsInfo record);
	
	Boolean updateByPrimarykeySelective(Goods goods);
	
	Boolean updateGoods(Goods goods);
	
	Boolean deleteById(Integer id);
	
	PageInfo<GoodsUrl> querySetInfoAndImgById(Integer id,Integer pageSize,Integer pageIndex);

	/**
	 * 分页查询
	 * @param goods
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
    PageInfo<GoodsVo> limitGoods(Goods goods, Integer pageSize, Integer pageIndex);

	/**
	 * 更新商品信息！
	 * @param goodsRe
	 * @return
	 */
	int updateGoodsRe(GoodsRe goodsRe);
}
