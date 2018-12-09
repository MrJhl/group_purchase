package com.group.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.group.shop.entity.GoodsMedia;

@Mapper
public interface GoodsMediaMapper {
    int insert(GoodsMedia record);

    int insertSelective(GoodsMedia record);
    
    int insertOrderBatch(List<GoodsMedia> record);

}