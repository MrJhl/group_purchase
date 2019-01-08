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

    /**
     * 根据用户进行查询
     * @param user
     * @return
     */
    User queryByUser(User user);
    
    /**
     * 根据名字或者手机号码获取用户
     * @param username
     * @return
     */
    User queryUserByNameOrphone(User user);
}