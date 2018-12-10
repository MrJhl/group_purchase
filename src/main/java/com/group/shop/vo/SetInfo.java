package com.group.shop.vo;

import java.util.List;

import com.group.shop.entity.Set;

public class SetInfo {
	
	private Integer shopId;
	private Set set;
	private List<Integer> mediaIds;

	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public List<Integer> getMediaIds() {
		return mediaIds;
	}
	public Set getSet() {
		return set;
	}
	public void setSet(Set set) {
		this.set = set;
	}
	public void setMediaIds(List<Integer> mediaIds) {
		this.mediaIds = mediaIds;
	}
	
	
}
