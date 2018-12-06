package com.group.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.group.shop.common.Constant;
import com.group.shop.common.GirlException;
import com.group.shop.common.ResultEnum;
import com.group.shop.entity.Admin;
import com.group.shop.mapper.AdminMapper;
import com.group.shop.service.AdminService;
import com.group.shop.utils.JwtTokenUtil;
import com.group.shop.utils.MD5Util;
import com.group.shop.vo.LoginInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class AdminServiceImpl implements AdminService {

    private final Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public LoginInfo login(Admin admin) {
        String pwd = MD5Util.MD5(admin.getPassword());
        Admin ad;
        try {
            ad = adminMapper.queryAdminByName(admin.getUsername ());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
        }
        if(ad == null){
            return null;
        }else if(!ad.getPassword().equals(pwd)) {
            return null;
        }else{
            String token = JwtTokenUtil.createToken(ad.getUsername(),"",true);
            LoginInfo loginInfo = new LoginInfo();

            loginInfo.setEmail(ad.getEmail());
            loginInfo.setGender(ad.getGender());
            loginInfo.setId(ad.getId());
            loginInfo.setPhone(ad.getPhone());
            loginInfo.setToken(token);
            loginInfo.setRealName(ad.getRealName());
            loginInfo.setUsername(ad.getUsername());
            redisTemplate.opsForValue().set(Constant.PC_TOKEN_REDIS + ":" + token,JSON.toJSONString(loginInfo),Constant.TOKEN_EXIST_TIME, TimeUnit.SECONDS);
            return loginInfo;
        }
    }

    @Override
    public boolean TokenLogin(String token) {
        Object obj = redisTemplate.opsForValue().get(token);
        if(obj != null){
            return true;
        }
        return false;
    }

    @Override
    public int insertAdmin(Admin admin) {
        Admin ad;
        try {
            ad = adminMapper.queryAdminByName(admin.getUsername());
        }catch (Exception e){
            log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
        }
        if(ad != null){
            return -1;
        }
        admin.setPassword(MD5Util.MD5(admin.getPassword()));
        admin.setCreateTime(new Date());
        admin.setLastEditTime(new Date());
        admin.setUserStatus(0);
        int insertNum;
        try {
            insertNum = adminMapper.insertAdmin(admin);
        }catch (Exception e){
            log.error(e.getMessage());
            throw new GirlException(ResultEnum.SYS_EXCEPTION);
        }
        return insertNum;
    }

    @Override
    public int updateAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int deleteAdmin(Integer id) {
        return 0;
    }
}
