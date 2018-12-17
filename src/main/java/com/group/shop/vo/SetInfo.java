package com.group.shop.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.group.shop.entity.Set;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SetInfo {
	private Set set;
	private List<Integer> mediaIds;
	
}
