package com.group.shop.service;

import java.util.List;

import com.group.shop.entity.Set;

public interface SetService {

	int deleteById(Integer id);

    int insertSet(Set record);

    Boolean insertSelective(Set record, List<Integer> mediaId);

    Set queryById(Integer id);

    int updateSet(Set set);
    
	
}
