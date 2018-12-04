package com.group.shop.mapper;

import com.group.shop.entity.Media;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MediaMapper {

    int deleteById(Integer id);

    int insertMedia(Media record);

    int insertSelective(Media media);

    Media queryById(Integer id);

    int updateByPrimaryKeySelective(Media media);

    int updateMedia(Media media);
}