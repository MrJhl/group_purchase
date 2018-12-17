package com.group.shop.controller;

import com.github.pagehelper.PageInfo;
import com.group.shop.common.Result;
import com.group.shop.entity.Set;
import com.group.shop.entity.Shop;
import com.group.shop.entity.ShopSet;
import com.group.shop.service.ShopSetService;
import com.group.shop.vo.ShopSetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "shopset")
public class ShopSetController {

    @Autowired
    private ShopSetService shopSetService;

    /**
     * 分页
     * @param shopId
     * @param setId
     * @param startTime
     * @param endTime
     * @param pageSize
     * @param pageIndex
     * @return
     */
    @GetMapping(value = "/limit",produces = {"application/json;charset=UTF-8"})
    public Result<Object> limitShopSet(@RequestParam(value = "shopId",required = false)Integer shopId,
                                       @RequestParam(value = "setId",required = false)Integer setId,
                                       @RequestParam(value = "startTime",required = false) Date startTime,
                                       @RequestParam(value = "endTime",required = false)Date endTime,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize,
                                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1")Integer pageIndex){
        ShopSet shopSet = new ShopSet();
        shopSet.setShopId(shopId);
        shopSet.setSetId(setId);
        shopSet.setEndTime(endTime);
        shopSet.setStartTime(startTime);
        PageInfo<ShopSetVo> pageInfo = shopSetService.limitShopSet(shopSet,pageIndex,pageSize);
        if(pageInfo.getTotal() > 0){
            Map<String,Object> map = new HashMap<>();
            map.put("total",pageInfo.getTotal());
            map.put("list",pageInfo.getList());
            return Result.success(map);
        }else{
            return Result.errorMsg("没有套餐信息！");
        }
    }
}
