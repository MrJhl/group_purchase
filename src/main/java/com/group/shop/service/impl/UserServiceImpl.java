package com.group.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.group.shop.common.Constant;
import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.User;
import com.group.shop.mapper.UserMapper;
import com.group.shop.service.UserService;
import com.group.shop.utils.JwtTokenUtil;
import com.group.shop.utils.MD5Util;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String wechatLogin(JSONObject object) {
        User user = new User();
        String key = object.get("session_key").toString();
        String openId = object.get("openid").toString();
        user.setOpenId(openId);
        User u;
        try {
            u = userMapper.queryByUser(user);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
        }
        String token = JwtTokenUtil.createToken(user.getOpenId(),"",true);

        if(u == null){
            user.setCreateTime(new Date());
            user.setLastEditTime(new Date());
            int num;
            try {
                 num = userMapper.insertSelective(user);
            }catch (Exception e){
                log.error(e.getMessage());
                throw new GirlException(ResultEnum.SYS_EXCEPTION);
            }
        }

        redisTemplate.opsForValue().set(Constant.WX_TOKEN_REDIS + ":" + token,
                JSON.toJSONString(user),Constant.TOKEN_EXIST_TIME, TimeUnit.SECONDS);
        return token;
    }

    @Override
    public Boolean verifyToken(String token) {
        Object object = redisTemplate.opsForValue().get(Constant.WX_TOKEN_REDIS + ":" + token);
        if(object == null){
            return false;
        }
        return true;
    }

	@Override
	public int insertUser(User user) {
		User usr;
		try {
			usr = userMapper.queryUserByNameOrphone(user);
		} catch (Exception e) {
			log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
		if(usr != null) {
			return -1;
		}
		user.setOpenId(MD5Util.MD5(user.getOpenId()));
		user.setCreateTime(new Date());
		user.setLastEditTime(new Date());
		int insertNum;
		try {
			insertNum = userMapper.insertUser(user);
		} catch (Exception e) {
			log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
		}
		
		return insertNum;
	}
}
