package com.group.shop.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.Goods;
import com.group.shop.entity.GoodsMedia;
import com.group.shop.mapper.GoodsMapper;
import com.group.shop.mapper.GoodsMediaMapper;
import com.group.shop.service.GoodsService;
import com.group.shop.vo.GoodsInfo;
import com.group.shop.vo.GoodsUrl;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

	private final Logger log = LoggerFactory.getLogger(GoodsService.class);
	
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsMediaMapper goodsMediaMapper;
	
	@Override
	public Goods queryById(Integer id) {
		return goodsMapper.queryById(id);
	}

	@Override
	public Boolean insertGoodsByGoods(Goods goods) {
		
		return goodsMapper.insertGoods(goods) == 1 ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public Boolean insertSelective(GoodsInfo record) {
		Goods goods = record.getGoods();
		goods.setIndex(0);
		goods.setCreateTime(new Date());
		goods.setLastEditTime(new Date());
		try {
			if (goodsMapper.insertSelective(goods) == 1) {
				List<Integer> mediaIds = record.getMediaIds();
				List<GoodsMedia> goodsMedias = new ArrayList<>();
				for (Integer mediaId : mediaIds) {
					GoodsMedia goodsMedia = new GoodsMedia();
					goodsMedia.setGoodsId(goods.getId());
					goodsMedia.setMediaId(mediaId);
					goodsMedias.add(goodsMedia);
				}
				return goodsMediaMapper.insertOrderBatch(goodsMedias) == record.getMediaIds().size()?Boolean.TRUE:Boolean.FALSE;
				
			} else {
				return Boolean.FALSE;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
		
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

	@Override
	public List<GoodsUrl> querySetInfoAndImgById(Integer id) {
		try {
			return goodsMapper.queryGoodsInfoAndImgById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
	}


}
