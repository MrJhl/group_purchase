package com.group.shop.common;

public class GirlException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6020663695787127693L;

	private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
