package com.group.shop.mapper;

import com.group.shop.entity.TbFreeBill;
import com.group.shop.entity.TbFreeBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbFreeBillMapper {
    int countByExample(TbFreeBillExample example);

    int deleteByExample(TbFreeBillExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbFreeBill record);

    int insertSelective(TbFreeBill record);

    List<TbFreeBill> selectByExample(TbFreeBillExample example);

    TbFreeBill selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbFreeBill record, @Param("example") TbFreeBillExample example);

    int updateByExample(@Param("record") TbFreeBill record, @Param("example") TbFreeBillExample example);

    int updateByPrimaryKeySelective(TbFreeBill record);

    int updateByPrimaryKey(TbFreeBill record);
}