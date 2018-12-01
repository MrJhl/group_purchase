package com.group.shop.mapper;

import com.group.shop.entity.TbGoodsOrder;
import com.group.shop.entity.TbGoodsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbGoodsOrderMapper {
    int countByExample(TbGoodsOrderExample example);

    int deleteByExample(TbGoodsOrderExample example);

    int insert(TbGoodsOrder record);

    int insertSelective(TbGoodsOrder record);

    List<TbGoodsOrder> selectByExample(TbGoodsOrderExample example);

    int updateByExampleSelective(@Param("record") TbGoodsOrder record, @Param("example") TbGoodsOrderExample example);

    int updateByExample(@Param("record") TbGoodsOrder record, @Param("example") TbGoodsOrderExample example);
}