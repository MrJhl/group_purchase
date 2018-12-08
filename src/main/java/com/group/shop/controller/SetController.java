package com.group.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.group.shop.common.Result;
import com.group.shop.entity.Set;
import com.group.shop.service.SetService;


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
	
    private final ResourceLoader resourceLoader;

    @Autowired
    public SetController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

//    @Value("${web.upload-path}")
//    private String path;

    
    /**
    *
    * @param file 套餐上传
    * @return
     * @throws IOException 
    */
    @SuppressWarnings("unchecked")
    @PostMapping(value = "",produces = {"application/json;charset=UTF-8"})
    public Result<Object> loginSystem(@RequestBody Map<String, Object> data){
	List<Integer> mediaIds =(ArrayList<Integer>) data.get("mediaIds");
       Set set = new Set();
 	   set.setName(data.get("setName").toString());
 	   set.setDescribe(data.get("setDescribe").toString());
 	   set.setPrice(Float.valueOf(data.get("setPrice").toString()));
 	   set.setSalePrice(Float.valueOf(data.get("setSalePrice").toString()));
 	   set.setTotal(0);
 	   set.setCreateTime(new Date());
 	   set.setLastEditTime(new Date());
 	   Boolean isInsert = setService.insertSelective(set, mediaIds);
        if(isInsert){
            return Result.success(true);
        }else{
            return Result.errorMsg("上传套餐数据失败！");
        }
    }
//    /**
//     * 显示单张图片
//     * @return
//     */
//    @RequestMapping("show")
//    public ResponseEntity showPhotos(String fileName){
//    	fileName = "dc43363c8a704b6ebfb0ac8ef408bfa4.jpg";
//    	
//        try {
//            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
//            return ResponseEntity.ok(resourceLoader.getResource("file:" + path + fileName));
//        } catch (Exception e) {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
