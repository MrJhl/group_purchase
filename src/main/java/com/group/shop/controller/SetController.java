package com.group.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.group.shop.config.file.FileUtils;
import com.group.shop.entity.Set;

import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/goodsshop/goodslist")
public class SetController {

//	@Autowired
//	private SetService setService;
//
//    private final ResourceLoader resourceLoader;
//
//    @Autowired
//    public SetController(ResourceLoader resourceLoader) {
//        this.resourceLoader = resourceLoader;
//    }
//
////    @Value("${web.upload-path}")
////    private String path;
//
//
//    /**
//    *
//    * @param file 套餐上传
//    * @return
//     * @throws IOException
//    */
//   @RequestMapping("fileUpload")
//   public int upload2(@RequestParam("fileName") MultipartFile file[]) throws IOException{
//	   List<String> url = new ArrayList<>();
//       // 显示图片
//	   List<Resource> photo = new ArrayList<>();
//       for (MultipartFile multipartFile : file) {
//    	   String photouri = FileUtils.saveImg(multipartFile);
//    	   photo.add(resourceLoader.getResource("file:" + photouri));
//    	   url.add(photouri);
//	}
//	   Set set = new Set();
//	   set.setName("套餐1");
//	   set.setDescribe("棒棒糖套餐");
//	   set.setPrice(new Float(1000));
//	   set.setSalePrice(new Float(1500));
//	   set.setTotal(0);
//	   set.setCreateTime(new Date());
//	   set.setLastEditTime(new Date());
//	   int num = setService.insertSelectiveBySetInfo(set, url);
////
//       return num;
//   }

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
