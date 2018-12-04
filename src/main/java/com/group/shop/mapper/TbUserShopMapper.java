package com.group.shop.mapper;

import com.group.shop.entity.TbUserShop;
import com.group.shop.entity.TbUserShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbUserShopMapper {
    int countByExample(TbUserShopExample example);

    int deleteByExample(TbUserShopExample example);

    int insert(TbUserShop record);

    int insertSelective(TbUserShop record);

    List<TbUserShop> selectByExample(TbUserShopExample example);

    int updateByExampleSelective(@Param("record") TbUserShop record, @Param("example") TbUserShopExample example);

    int updateByExample(@Param("record") TbUserShop record, @Param("example") TbUserShopExample example);
}