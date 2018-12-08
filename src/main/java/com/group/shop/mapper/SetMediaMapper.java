package com.group.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.group.shop.entity.SetMedia;

@Mapper
public interface SetMediaMapper {
    int insert(SetMedia record);

    int insertSelective(SetMedia record);
    
    int insertOrderBatch(List<SetMedia> record);

}