package com.group.shop.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.group.shop.common.CodeMsg;
import com.group.shop.common.Result;
import com.group.shop.config.file.FileUtils;
import com.group.shop.entity.Goods;
import com.group.shop.entity.Media;
import com.group.shop.service.GoodsService;
import com.group.shop.service.MediaService;

/**
 * @deprecated 商品操作控制层
 * @author Jin
 * @Data 2018/12/04
 */

@RestController
@RequestMapping(value = "/media")
public class MediaController {
	
	@Autowired
	private MediaService mediaService;
	
	//上传照片
	@PostMapping(value = "",produces = {"application/json;charset=UTF-8"})
	public Result<List<Integer>> getGoodsInfo(@RequestParam(name = "fileName") MultipartFile file[]){
		List<String> url = new ArrayList<>();
       // 显示图片
       for (MultipartFile multipartFile : file) {
    	   String photouri = FileUtils.saveImg(multipartFile);
    	   url.add(photouri);
	}
       List<Integer> mediaIds = mediaService.insertOrderBatch(url);
       if(!mediaIds.isEmpty()){
           return Result.success(mediaIds);
       }else{
           return Result.error(CodeMsg.FAIL);
       }
	}
	
	
}
