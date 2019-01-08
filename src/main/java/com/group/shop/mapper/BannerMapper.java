package com.group.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.group.shop.entity.Banner;

@Mapper
public interface BannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
    
    List<Banner> selectAll();
}