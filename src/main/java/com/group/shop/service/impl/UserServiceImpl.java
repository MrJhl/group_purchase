package com.group.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.group.shop.common.Constant;
import com.group.shop.entity.User;
import com.group.shop.mapper.UserMapper;
import com.group.shop.service.UserService;
import com.group.shop.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Map<String,Object> wechatLogin(User user) {
        Map<String,Object> map = new HashMap<>();
        User userTemp = new User();
        User u = userMapper.queryByUser(user);
        String token = JwtTokenUtil.createToken(user.getUsername(),"",true);

        if(u != null){
            userTemp = u;
        }else{
            user.setCreateTime(new Date());
            user.setLastEditTime(new Date());
            int num = userMapper.insertSelective(user);
            userTemp = user;
        }

        redisTemplate.opsForValue().set(Constant.WX_TOKEN_REDIS + ":" + token, JSON.toJSONString(userTemp),Constant.TOKEN_EXIST_TIME, TimeUnit.SECONDS);
        map.put("token",token);
        map.put("user",userTemp);
        return map;
    }
}
