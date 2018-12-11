package com.group.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.shop.common.Result;
import com.group.shop.entity.Order;
import com.group.shop.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 根据店家查询订单信息
	 * @param userId
	 * @return
	 */
	@GetMapping(value="", produces= {"application/json; charset=UTF-8"})
	public Result<List<Order>> getUserOrderlist(@RequestParam(name="userId",required=true) int userId){
		List<Order> orders = orderService.queryByUserId(userId);
		if(orders != null) {
			return Result.success(orders);
		}else {
			return Result.errorMsg("获取商铺订单信息失败！");
		}
	}
	/**
	 * 生成新订单
	 * @param order
	 * @return
	 */
	@PostMapping(value="", produces= {"application/json; charset=UTF-8"})
	public Result<Object> insertOrder(@RequestBody Order order){
		if(orderService.insertOrder(order)) {
			return Result.success(true);
		}else {
			return Result.errorMsg("生成新订单失败！");
		}
	}
	
	@PutMapping(value="", produces= {"application/json; charset=UTF-8"})
	public Result<Object> upsetOrder(@RequestBody Order order){
		if(orderService.updateByPrimaryKeySelective(order)) {
			return Result.success(true);
		}else {
			return Result.errorMsg("修改订单信息失败！");
		}
	}
	
}
