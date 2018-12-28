package com.group.shop.controller;

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
import com.group.shop.entity.Cart;
import com.group.shop.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping
	public Result<List<Cart>> getCartList(@RequestParam(name = "userId") int userId){
		
		
		return null;
	}
	
	@PostMapping
	public Result<Object> addCart(@RequestBody Cart cart) {
		if(cartService.insert(cart)) {
			return Result.success(CodeMsg.SUCCESS);
		}else {
			return Result.errorMsg("添加失败");
		}
	}
	
	@PutMapping(value = "/mulShop", produces= {"application/json; charset=UTF-8"})
	public Result<Object> addCarts(@RequestBody List<Cart> carts) {
		if(cartService.insertOrUpdateList(carts)) {
			return Result.success(CodeMsg.SUCCESS);
		}else {
			return Result.errorMsg("新增或更新失败");
		}
	}
	
	@DeleteMapping
	public Result<Object> deleteCart(@RequestParam(name = "id") int id) {
		if (cartService.deleteByPrimaryKey(id)) {
			return Result.success(CodeMsg.SUCCESS);
		}else {
			return Result.errorMsg("删除失败！");
		}
	}
	
}
