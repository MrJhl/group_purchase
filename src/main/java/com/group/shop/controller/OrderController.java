package com.group.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.group.shop.entity.Goods;
import com.group.shop.entity.Shop;
import com.group.shop.entity.User;
import com.group.shop.vo.OrderVo;
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
	@GetMapping(produces= {"application/json; charset=UTF-8"})
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
	@PostMapping(produces= {"application/json; charset=UTF-8"})
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

	/**
	 * 分页查询
	 * @param shopId
	 * @param shopName
	 * @param userId
	 * @param username
	 * @param goodsId
	 * @param goodsName
	 * @param orderNum
	 * @param orderId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "limit",produces = {"application/json;charset=UTF-8"})
	public Result<Object> limitOrder(@RequestParam(name = "shopId",required = false)Integer shopId,
									 @RequestParam(name = "shopName",required = false)String shopName,
									 @RequestParam(name = "userId",required = false)Integer userId,
									 @RequestParam(name = "username",required = false)String username,
									 @RequestParam(name = "goodsId",required = false)Integer goodsId,
									 @RequestParam(name = "goodsName",required = false)String goodsName,
									 @RequestParam(name = "orderNum",required = false)String orderNum,
									 @RequestParam(name = "orderStatus",required = false)Integer orderStatus,
									 @RequestParam(name = "pageIndex",required = false,defaultValue = "1")Integer pageIndex,
									 @RequestParam(name = "pageSize",required = false,defaultValue = "20")Integer pageSize){
		Goods goods = new Goods();
		goods.setName(goodsName);
		goods.setId(goodsId);
		Shop shop = new Shop();
		shop.setId(shopId);
		shop.setName(shopName);
		User user = new User();
		user.setId(userId);
		user.setUsername(username);
		OrderVo orderVo = new OrderVo();
		orderVo.setGoods(goods);
		orderVo.setNumber(orderNum);
		orderVo.setShop(shop);
		orderVo.setUser(user);
		orderVo.setStatus(orderStatus);
		PageInfo<OrderVo> pageInfo = orderService.limitOrderVo(orderVo,pageIndex,pageSize);

		if(pageInfo.getTotal() > 0){
			Map<String,Object> map = new HashMap<>();
			map.put("total",pageInfo.getTotal());
			map.put("data",pageInfo.getList());

			return Result.success(map);
		}else{
			return Result.errorMsg("没有订单信息！");
		}
	}
	
}
