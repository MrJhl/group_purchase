package com.group.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.ShopSet;
import com.group.shop.mapper.ShopSetMapper;
import com.group.shop.service.ShopSetService;
import com.group.shop.vo.ShopSetVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShopSetServiceImpl implements ShopSetService {

    @Autowired
    private ShopSetMapper shopSetMapper;

    @Override
    public PageInfo<ShopSetVo> limitShopSet(ShopSet shopSet, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<ShopSetVo> shopSetVoList;
        try {
            shopSetVoList = shopSetMapper.getShopSetVoList(shopSet);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
        }
        return new PageInfo<>(shopSetVoList);
    }
}
