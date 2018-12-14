package com.group.shop.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Goods;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GoodsInfo {

	private Goods goods;
    private List<Integer> mediaIds;
	
}
