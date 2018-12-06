package com.group.shop.utils;

import com.alibaba.fastjson.JSON;
import com.group.shop.entity.User;

import com.group.shop.vo.LoginInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class RedisUtil {

    /**
     * 通过redis获取用户信息
     * @param request
     * @return
     */
    public static LoginInfo getUserByRedis(HttpServletRequest request) {
        String token = request.getHeader("token");
        if(!StringUtils.isEmpty(token)) {
            StringRedisTemplate redisTemplate=SpringContextHolder.getBean(StringRedisTemplate.class);
            String userJson=redisTemplate.opsForValue().get(token);
            LoginInfo loginInfo = JSON.parseObject(userJson, LoginInfo.class);
            return loginInfo;
        }
        return null;
    }

}
