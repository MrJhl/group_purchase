package com.group.shop.service;

import java.util.List;

import com.group.shop.entity.Media;

public interface MediaService {

	/**
	 * @deprecated 插入多条媒体数据
	 * @param record
	 * @return
	 */
	List<Integer> insertOrderBatch(List<String> record);
	
}
