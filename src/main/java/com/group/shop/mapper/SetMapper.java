package com.group.shop.mapper;

import com.group.shop.entity.Set;
import com.group.shop.vo.SetUrl;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetMapper {

    int deleteById(Integer id);

    int insertSet(Set record);

    int insertSelective(Set record);

    Set queryById(Integer id);
    
    SetUrl querySetInfoAndimgById(Integer id);
    
    int updateSet(Set set);

}