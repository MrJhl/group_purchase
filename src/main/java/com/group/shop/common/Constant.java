package com.group.shop.common;

public class Constant {

    /**
     * pc端登录存在Redis的token
     */
    public static final String PC_TOKEN_REDIS = "pc_token_redis";

    /**
     * pc端登录存在Redis的token
     */
    public static final String WX_TOKEN_REDIS = "wx_token_redis";

    /**
     * token存活时间
     */
    public static final long TOKEN_EXIST_TIME = 24*60*30;

    /**
     *
     */
    public static final String  CODE_SESSION = "https://api.weixin.qq.com/sns/jscode2session";
}
