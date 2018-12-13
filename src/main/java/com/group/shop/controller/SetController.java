package com.group.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.shop.common.Result;
import com.group.shop.service.SetService;
import com.group.shop.vo.SetInfo;
import com.group.shop.vo.SetUrl;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/set")
public class SetController {

	@Autowired
	private SetService setService; 
	

//    @Value("${web.upload-path}")
//    private String path;

    
    /**
    *
    * @param file 套餐上传
    * @return
     * @throws IOException 
    */
    @PostMapping(value = "",produces = {"application/json;charset=UTF-8"})
    public Result<Object> loginSystem(@RequestBody SetInfo setInfo){
      
 	   Boolean isInsert = setService.insertSelective(setInfo);
        if(isInsert){
            return Result.success(true);
        }else{
            return Result.errorMsg("上传套餐数据失败！");
        }
    }
    
	@GetMapping(value= "",produces = {"application/json;charset=UTF-8"})
	public Result<List<SetUrl>> getPhotoUrl(@RequestParam(name = "shopId",required = true) int shopId){
		List<SetUrl> setUrls = setService.querySetInfoAndImgById(shopId);
		if(!setUrls.isEmpty() && setUrls != null) {
			return Result.success(setUrls);
		}else {
			return Result.errorMsg("获取大套餐数据失败！");
		}
	}


}
