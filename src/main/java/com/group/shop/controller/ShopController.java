package com.group.shop.controller;

import com.github.pagehelper.PageInfo;
import com.group.shop.common.Result;
import com.group.shop.entity.Shop;
import com.group.shop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    /**
     * 分页查询
     * @param name
     * @param num
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/limit",produces = {"application/json;charset=UTF-8"})
    public Result<Object> limitShop(@RequestParam(name = "name",required = false)String name,
                                  @RequestParam(name = "shopId",required = false)Integer shopId,
                                  @RequestParam(name = "num",required = false)String num,
                                  @RequestParam(name = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
                                  @RequestParam(name = "pageSize",required = false,defaultValue = "20")Integer pageSize){
        Shop shop = new Shop();
        shop.setName(name);
        shop.setNum(num);
        shop.setId(shopId);
        PageInfo<Shop> pageInfo = shopService.limitShop(shop,pageIndex,pageSize);

        if(pageInfo.getTotal() > 0){
            Map<String,Object> map = new HashMap<>();
            map.put("total",pageInfo.getTotal());
            map.put("data",pageInfo.getList());
            return Result.success(map);
        }else{
            return Result.errorMsg("没有店铺信息！");
        }
    }
}
