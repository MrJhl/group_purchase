package com.group.shop.common;


/**
 * 统一API响应结果封装
 */
public class Result<T> {
	
	private int code;
	private String msg;
	private T data;
	
	/**
	 *  成功时候的调用
	 * */
	public static  <T> Result<T> success(T data){
		Result<T> result=new Result<T>(CodeMsg.SUCCESS);
		result.setData(data);
		return result;
	}
	
	/**
	 *  成功时候的调用
	 * */
	public static <T> Result<T> successMsg(String msg){
		return new Result<T>(200,msg);
	}
	
	/**
	 *  失败时候的调用
	 * */
	public static  <T> Result<T> error(CodeMsg codeMsg){
		return new Result<T>(codeMsg);
	}
	
	/**
	 *  失败时候的调用
	 * */
	public static <T> Result<T> errorMsg(String msg){
		return new Result<T>(0,msg);
	}
	
	private Result(T data) {
		this.data = data;
	}
	
	private Result(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	private Result(CodeMsg codeMsg) {
		if(codeMsg != null) {
			this.code = codeMsg.getCode();
			this.msg = codeMsg.getMsg();
		}
	}
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
