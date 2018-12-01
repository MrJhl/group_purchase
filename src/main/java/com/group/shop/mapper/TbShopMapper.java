package com.group.shop.mapper;

import com.group.shop.entity.TbShop;
import com.group.shop.entity.TbShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbShopMapper {
    int countByExample(TbShopExample example);

    int deleteByExample(TbShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbShop record);

    int insertSelective(TbShop record);

    List<TbShop> selectByExample(TbShopExample example);

    TbShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbShop record, @Param("example") TbShopExample example);

    int updateByExample(@Param("record") TbShop record, @Param("example") TbShopExample example);

    int updateByPrimaryKeySelective(TbShop record);

    int updateByPrimaryKey(TbShop record);
}