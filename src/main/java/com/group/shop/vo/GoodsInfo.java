package com.group.shop.vo;

import java.util.List;

import com.group.shop.entity.Goods;

public class GoodsInfo {

	private Goods goods;

    private List<Integer> mediaIds;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List<Integer> getMediaIds() {
		return mediaIds;
	}

	public void setMediaIds(List<Integer> mediaIds) {
		this.mediaIds = mediaIds;
	}
    
    
	
}
