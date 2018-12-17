package com.group.shop.controller;

import com.group.shop.common.Result;
import com.group.shop.entity.Set;
import com.group.shop.service.SetService;
import com.group.shop.vo.SetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/set")
public class SetController {

    @Autowired
    private SetService setService;

    /**
     * 插入套餐信息
     * @param setInfo
     * @return
     */
    @PostMapping(produces = {"application/json;charset=UTF-8"})
    public Result<Boolean> insertSet(@RequestBody SetInfo setInfo){
        boolean isSuccess = setService.insertSetInfo(setInfo);
        if(isSuccess){
            return Result.success(true);
        }else{
            return Result.errorMsg("插入套餐信息失败！");
        }
    }

    /**
     * 查询套餐列表
     * @return
     */
    @GetMapping(value = "/setlist",produces = {"application/json;charset=UTF-8"})
    public Result<Object> setList(){
        Set set = new Set();
        List<Set> setList = setService.getSetList(set);
        if(setList.size() > 0){
            return Result.success(setList);
        }else {
            return Result.errorMsg("不存在套餐信息！");
        }
    }

    @GetMapping(value = "/limit",produces = {"application/json;charset=UTF-8"})
    public Result<Object> limitSet(@RequestParam(value = "name")String name,
                                   @RequestParam(value = "pageSize",required = false,defaultValue = "20")Integer pageSize,
                                   @RequestParam(value = "pageIndex",required = false,defaultValue = "0")Integer pageIndex){

        return null;
    }
}
