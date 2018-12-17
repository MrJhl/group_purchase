package com.group.shop.service;

import java.util.List;

import com.group.shop.entity.Set;
import com.group.shop.vo.SetInfo;
import com.group.shop.vo.SetUrl;

public interface SetService {

	int deleteById(Integer id);

    int insertSet(Set record);

//    Boolean insertSelective(SetInfo record);

    Set queryById(Integer id);

    int updateSet(Set set);
    
    List<SetUrl> querySetInfoAndImgById(Integer id);

    /**
     * 插入套餐信息
     * @param setInfo
     * @return
     */
    boolean insertSetInfo(SetInfo setInfo);

    List<Set> getSetList(Set set);
}
