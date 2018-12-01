package com.group.shop.common;

public enum ResultEnum {

	UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(1, "成功"),
    EXIST_EXCEPTION(-400,"存在相同数据异常"),
    NULL_INFO(-500,"空数据异常！"),
    OPERATE_FAIL(-200,"存在相同数据异常"),
    SYS_EXCEPTION(-100,"系统异常"), LIMIT_AUTHORITY(-300,"权限不够");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
