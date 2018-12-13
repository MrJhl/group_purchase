package com.group.shop.vo;

import java.util.List;

import com.group.shop.entity.Goods;

public class GoodsUrl extends Goods{
	private List<String> url;

	public List<String> getUrl() {
		return url;
	}

	public void setUrl(List<String> url) {
		this.url = url;
	}
	
	
}
