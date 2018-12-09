package com.group.shop.service;


import com.group.shop.entity.Set;
import com.group.shop.vo.SetInfo;

public interface SetService {

	int deleteById(Integer id);

    int insertSet(Set record);

    Boolean insertSelective(SetInfo record);

    Set queryById(Integer id);

    int updateSet(Set set);
    
	
}
