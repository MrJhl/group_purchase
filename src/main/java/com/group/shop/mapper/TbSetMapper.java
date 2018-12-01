package com.group.shop.mapper;

import com.group.shop.entity.TbSet;
import com.group.shop.entity.TbSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSetMapper {
    int countByExample(TbSetExample example);

    int deleteByExample(TbSetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbSet record);

    int insertSelective(TbSet record);

    List<TbSet> selectByExample(TbSetExample example);

    TbSet selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbSet record, @Param("example") TbSetExample example);

    int updateByExample(@Param("record") TbSet record, @Param("example") TbSetExample example);

    int updateByPrimaryKeySelective(TbSet record);

    int updateByPrimaryKey(TbSet record);
}