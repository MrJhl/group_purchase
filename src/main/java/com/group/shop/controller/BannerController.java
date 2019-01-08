package com.group.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.shop.common.CodeMsg;
import com.group.shop.common.Result;
import com.group.shop.entity.Banner;
import com.group.shop.entity.Cart;
import com.group.shop.service.BannerService;

@RestController
@RequestMapping("/banner")
public class BannerController {

	@Autowired
	private BannerService bannerService;
	
	/**
	 * 获取所有数据
	 * @return
	 */
	@GetMapping
	public Result<List<Banner>> getBannerList(){
		List<Banner> banners = bannerService.selectAll();
		if(!banners.isEmpty()) {
			return Result.success(banners);
		}else {
			return Result.errorMsg("Banner查询失败");
		}
	}
	
	/**
	 * 保存单个数据
	 * @param banner
	 * @return
	 */
	@PostMapping(produces = {"application/json;charset=UTF-8"})
	public Result<Object> addBanner(@RequestBody Banner banner) {
		int flag = bannerService.insertBanner(banner);
		if(flag == 1) {
			return Result.success(CodeMsg.SUCCESS);
		}else {
			return Result.errorMsg("Banner添加失败");
		}
	}
	/**
	 * 保存多个数据
	 * @param banner
	 * @return
	 */
	@PostMapping(value = "/list",produces = {"application/json;charset=UTF-8"})
	public Result<Object> addBannerList(@RequestBody List<Banner> banners) {
		List<Banner> req = new ArrayList<>();
		for (Banner banner : banners) {
			int flag = bannerService.insertBanner(banner);
			if(flag == 1) {
				req.add(banner);
			}
		}
		if (req.size() == banners.size()) {
			return Result.success(true);
		}else if(!req.isEmpty() && req.size() != banners.size()){
			return Result.errorMsg("部分上传成功:"+req.toString());
		}else {
			return Result.errorMsg("上传失败");
		}
		
		
	}
	/**
	 * 修改单个数据
	 * @param banner
	 * @return
	 */
	@PutMapping(produces = {"application/json;charset=UTF-8"})
	public Result<Object> updateBanner(@RequestBody Banner banner) {
		if(bannerService.updateSelectiveBanner(banner)) {
			return Result.success(CodeMsg.SUCCESS);
		}else {
			return Result.errorMsg("Banner添加失败");
		}
	}
	
	/**
	 * 删除单个数据
	 * @param id
	 * @return
	 */
	@DeleteMapping
	public Result<Boolean> DeleteBanner(@RequestParam(name = "id")int id){
		if(bannerService.delete(id)) {
			return Result.success(true);
		}else {
			 return Result.error(CodeMsg.FAIL);
		}
	}
}
