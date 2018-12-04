package com.group.shop.mapper;

import com.group.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int deleteById(Integer id);

    int insertUser(User user);

    int insertSelective(User user);

    User queryById(Integer id);

    int updateUser(User user);
}