package com.group.shop.mapper;

import com.group.shop.entity.TbMedia;
import com.group.shop.entity.TbMediaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbMediaMapper {
    int countByExample(TbMediaExample example);

    int deleteByExample(TbMediaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbMedia record);

    int insertSelective(TbMedia record);

    List<TbMedia> selectByExample(TbMediaExample example);

    TbMedia selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbMedia record, @Param("example") TbMediaExample example);

    int updateByExample(@Param("record") TbMedia record, @Param("example") TbMediaExample example);

    int updateByPrimaryKeySelective(TbMedia record);

    int updateByPrimaryKey(TbMedia record);
}