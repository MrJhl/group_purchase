package com.group.shop.vo;

import java.util.List;

public class SetInfo {

	private String name;
	private String describe;
	private Float price;
	private Float salePrice;
	private List<Integer> mediaIds;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}
	public List<Integer> getMediaIds() {
		return mediaIds;
	}
	public void setMediaIds(List<Integer> mediaIds) {
		this.mediaIds = mediaIds;
	}
	
	
}
