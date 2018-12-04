package com.group.shop.utils;

import com.alibaba.fastjson.JSON;
import com.group.shop.entity.User;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class RedisUtil {

    private static String phoneToken;

//    @Value("${phone.token.cookie.name}")
//    public void setPhoneToken(String phoneToken) {
//        RedisUtil.phoneToken = phoneToken;
//    }
//
    private static String tokenInfo;
//
//    @Value("${token.cookie.name}")
//    public void setTokenInfo(String tokenInfo) {
//        RedisUtil.tokenInfo = tokenInfo;
//    }

    /**
     * 通过redis获取用户信息
     * @param request
     * @return
     */
    public static User getUserByRedis(HttpServletRequest request) {
        String token = request.getHeader("token");
        if(!StringUtils.isEmpty(token)) {
            StringRedisTemplate redisTemplate=SpringContextHolder.getBean(StringRedisTemplate.class);
            String userJson=redisTemplate.opsForValue().get(tokenInfo + ":" + token);
            User user = JSON.parseObject(userJson,User.class);
            return user;
        }
        return null;
    }

    /**
     * 通过redis获取用户信息
     * @param request
     * @return
     */
    public static User phoneGetUserByRedis(HttpServletRequest request) {
        String token = request.getHeader("token");
        if(!StringUtils.isEmpty(token)) {
            StringRedisTemplate redisTemplate=SpringContextHolder.getBean(StringRedisTemplate.class);
            String userJson=redisTemplate.opsForValue().get(phoneToken + ":" + token);
            User user =JSON.parseObject(userJson,User.class);
            return user;
        }
        return null;
    }

}
