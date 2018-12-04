package com.group.shop.common;

public class CodeMsg {
	
	private int code;
	private String msg;
	
	//通用的错误码
	//成功是的code
	public static CodeMsg SUCCESS = new CodeMsg(200, "success");
	//失败时的code
	public static CodeMsg FAIL = new CodeMsg(0, "fail");
	//服务器内部错误
	public static CodeMsg SERVER_EXCEPTION = new CodeMsg(500, "服务器内部异常");
	
	//服务器参数
	public static CodeMsg METHOD_ARG_TYPE_EXCEPTION = new CodeMsg(405, "参数异常");
	
	//二维码过期
	public static CodeMsg QRCODE_OVERDUE = new CodeMsg(4001, "二维码过期");
	
	//二维码未认证(没有确认登录)
	public static CodeMsg QRCODE_NO_AUTH = new CodeMsg(4002, "二维码未认证");
	
	//token过期
	public static CodeMsg TOKEN_OVERDUE = new CodeMsg(4003, "token过期");
	
	//无token
	public static CodeMsg TOKEN_NON = new CodeMsg(4004, "无token");
	
	//token不合法
	public static CodeMsg TOKEN_ERROR = new CodeMsg(4005, "token异常");
		
	private CodeMsg( ) {
	}
			
	private CodeMsg( int code,String msg ) {
		this.code = code;
		this.msg = msg;
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
	
	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
	
	
}
