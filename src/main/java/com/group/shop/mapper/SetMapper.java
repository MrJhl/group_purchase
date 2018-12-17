package com.group.shop.mapper;

import com.group.shop.entity.Set;
import com.group.shop.vo.SetUrl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SetMapper {

    int deleteById(Integer id);

    int insertSet(Set record);

    int insertSelective(Set record);

    Set queryById(Integer id);
    
    List<SetUrl> querySetInfoAndImgById(Integer id);
    
    int updateSet(Set set);

    /**
     * 获取套餐列表
     * @param set
     * @return
     */
    List<Set> getSetList(Set set);
}