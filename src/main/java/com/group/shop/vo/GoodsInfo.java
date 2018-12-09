package com.group.shop.vo;

import java.util.Date;
import java.util.List;

public class GoodsInfo {

    private String name;

    private String describe;

    private String standard;

    private Float price;
    
    private Float salePrice;
    
    private Integer setId;

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

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
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

	public Integer getSetId() {
		return setId;
	}

	public void setSetId(Integer setId) {
		this.setId = setId;
	}

	public List<Integer> getMediaIds() {
		return mediaIds;
	}

	public void setMediaIds(List<Integer> mediaIds) {
		this.mediaIds = mediaIds;
	}
    
    
	
}
