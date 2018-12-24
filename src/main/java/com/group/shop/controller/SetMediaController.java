package com.group.shop.controller;

import com.group.shop.common.Result;
import com.group.shop.entity.SetMedia;
import com.group.shop.service.SetMediaService;
import com.group.shop.vo.SetMediaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "setMedia")
public class SetMediaController {

    @Autowired
    private SetMediaService setMediaService;

    /**
     * 插入套餐信息
     * @param setMediaVo
     * @return
     */
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public Result<Object> insetSetMedia(@RequestBody SetMediaVo setMediaVo){
        int num = setMediaService.insertSetMediaVo(setMediaVo);

        if(num == 1){
            return Result.success("插入成功！");
        }else{
            return Result.errorMsg("插入套餐信息失败！");
        }
    }
}
