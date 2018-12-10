package com.group.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.group.shop.common.Result;
import com.group.shop.entity.Set;
import com.group.shop.service.SetService;
import com.group.shop.vo.SetInfo;
import com.group.shop.vo.SetUrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
	public Result<SetUrl> getPhotoUrl(@RequestParam(name = "setId",required = true) int setId){
		SetUrl setUrl = setService.querySetInfoAndimgById(setId);
		if(setUrl != null) {
			return Result.success(setUrl);
		}else {
			return Result.errorMsg("获取大套餐数据失败！");
		}
	}



}
