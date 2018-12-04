package com.group.shop.mapper;

import com.group.shop.entity.FreeBill;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FreeBillMapper {

    int deleteById(Integer id);

    int insertFreeBill(FreeBill freeBill);

    int insertSelective(FreeBill record);

    FreeBill queryById(Integer id);

    int updateByPrimaryKeySelective(FreeBill freeBill);

    int updateFreeBill(FreeBill freeBill);
}