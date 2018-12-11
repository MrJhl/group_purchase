package com.group.shop.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.group.shop.common.CodeMsg;
import com.group.shop.common.Result;
import com.group.shop.entity.Goods;
import com.group.shop.service.GoodsService;

/**
 * @deprecated 商品操作控制层
 * @author Jin
 * @Data 2018/12/04
 */

@RestController
@RequestMapping(value = "/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;

	@GetMapping(produces = {"application/json;charset=UTF-8"})
	public Result<Object> getGoodsById(@RequestParam(name = "id",required = true)Integer id){
		Goods goods = goodsService.queryById(id);
		if(goods != null) {
			return Result.success(goods);
		}else {
			return Result.error(CodeMsg.FAIL);
		}
	}

	@PostMapping(produces = {"application/json;charset=UTF-8"})
	public Result<Object> insertGoods(@RequestBody Goods goods) {
		if (goodsService.insertSelective(goods)) {
			return Result.success(CodeMsg.SUCCESS);
		} else {
			return Result.error(CodeMsg.FAIL);
		}
	}

	@PutMapping(produces = {"application/json;charset=UTF-8"})
	public Result<String> updateGoods(@RequestBody Goods goods){
		if(goodsService.updateByPrimarykeySelective(goods)){
			return Result.success("更新成功！");
		}else{
			return Result.errorMsg("更新失败！");
		}
	}

	
//	//根据goodsId查询单个商品
//	@GetMapping(value = "/goodslist/{goodsId}",produces = {"application/json;charset=UTF-8"})
//	public Result<Object> getGoodsInfo(@PathVariable int goodsId){
//		Goods goods = goodsService.queryById(goodsId);
//		if(goods != null) {
//			return Result.success(goods);
//		}else {
//			return Result.error(CodeMsg.FAIL);
//		}
//	}
//
	@DeleteMapping(produces = {"application/json;charset=UTF-8"})
	public Result<Boolean> deleteGoods(@RequestParam(name = "id",required = true)Integer id){
		if(goodsService.deleteById(id)) {
			return Result.success(true);
		}else {
			return Result.error(CodeMsg.FAIL);
		}
	}
	
//	//根据goods添加单个商品信息
//	@PostMapping(value = "/goodslist",produces = {"application/json;charset=UTF-8"})
//	public Result<Object> insertGoods(@RequestBody Goods goods){
//			if(goodsService.insertSelective(goods)){
//	            return Result.success(CodeMsg.SUCCESS);
//	        }else{
//	            return Result.error(CodeMsg.FAIL);
//	        }
//	}
	//根据修改后的goods更新单个商品信息
//	@PutMapping(value = "/goodslist",produces = {"application/json;charset=UTF-8"})
//	public Result<Object> updateGoods(@RequestBody Goods goods){
//			if(goodsService.updateByPrimarykeySelective(goods)){
//	            return Result.success(CodeMsg.SUCCESS);
//	        }else{
//	            return Result.error(CodeMsg.FAIL);
//	        }
//	}
	
	//根据goodsId删除单个商品
	@DeleteMapping(value = "/goodslist/{goodsId}",produces = {"application/json;charset-UTF-8"})
	public Result<Object> deleteGoods(@PathVariable int goodsId){
		if(goodsService.deleteById(goodsId)) {
			return Result.success(CodeMsg.SUCCESS);
		}else {
			return Result.error(CodeMsg.FAIL);
		}
	}

	
}
