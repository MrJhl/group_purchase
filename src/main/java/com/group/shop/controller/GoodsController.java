package com.group.shop.controller;

import java.util.HashMap;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.group.shop.vo.GoodsVo;
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

import com.group.shop.common.CodeMsg;
import com.group.shop.common.Result;
import com.group.shop.entity.Goods;
import com.group.shop.service.GoodsService;
import com.group.shop.vo.GoodsUrl;

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
	
	//根据goodsId查询单个商品
	@GetMapping(produces = {"application/json;charset=UTF-8"})
	public Result<Object> getGoodsInfo(@RequestParam(name = "goodsId",required = true) int goodsId){
		Goods goods = goodsService.queryById(goodsId);
		if(goods != null) {
			return Result.success(goods);
		}else {
			return Result.error(CodeMsg.FAIL);
		}
	}
	
	@GetMapping(value= "/list",produces = {"application/json;charset=UTF-8"})
	public Result<Map<String, Object>> getGoodsInfoAndImg(@RequestParam(name = "setId",required = true) int setId, 
			 @RequestParam(name="pageSize",required = false,defaultValue = "20")Integer pageSize,
			 @RequestParam(name="pageIndex",required = false,defaultValue = "0")Integer pageIndex){
		PageInfo<GoodsUrl> pageInfo = goodsService.querySetInfoAndImgById(setId,pageSize,pageIndex);
		Map<String,Object> map = new HashMap<>();
		if(pageInfo.getSize() > 0) {
			map.put("total", pageInfo.getTotal());
			map.put("data", pageInfo.getList());
			return Result.success(map);
		}else {
			return Result.errorMsg("获取小套餐失败！");
		}
	}
	//根据goods添加单个商品信息
	@PostMapping(produces = {"application/json;charset=UTF-8"})
	public Result<Object> insertGoods(@RequestBody Goods goods){
		if(goodsService.insetGoods(goods)){
			return Result.success(CodeMsg.SUCCESS);
		}else{
			return Result.error(CodeMsg.FAIL);
		}
	}
	//根据修改后的goods更新单个商品信息
	@PutMapping(produces = {"application/json;charset=UTF-8"})
	public Result<Object> updateGoods(@RequestBody Goods goods){
			if(goodsService.updateByPrimarykeySelective(goods)){
	            return Result.success(CodeMsg.SUCCESS);
	        }else{
	            return Result.error(CodeMsg.FAIL);
	        }
	}
	
	//根据goodsId删除单个商品
	@DeleteMapping(value = "/goodslist/{goodsId}",produces = {"application/json;charset-UTF-8"})
	public Result<Object> deleteGoods(@PathVariable int goodsId){
		if(goodsService.deleteById(goodsId)) {
			return Result.success(CodeMsg.SUCCESS);
		}else {
			return Result.error(CodeMsg.FAIL);
		}
	}

	/**
	 * 分页
	 * @param name
	 * @param pageSize
	 * @param pageIndex
	 * @return
	 */
	@GetMapping(value = "/limit",produces = {"application/json;charset=UTF-8"})
	public Result<Object> limitGoods(@RequestParam(name = "name",required = false)String name,
									 @RequestParam(name="pageSize",required = false,defaultValue = "20")Integer pageSize,
									 @RequestParam(name="pageIndex",required = false,defaultValue = "0")Integer pageIndex){
		Goods goods = new Goods();
		goods.setName(name);
		PageInfo<GoodsVo> pageInfo = goodsService.limitGoods(goods,pageSize,pageIndex);

		Map<String,Object> map = new HashMap<>();

		if(pageInfo.getSize() > 0){
			map.put("total",pageInfo.getTotal());
			map.put("data",pageInfo.getList());
			return Result.success(map);
		}else{
			return Result.successMsg("不存在商品信息列表");
		}
	}
}
