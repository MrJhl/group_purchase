package com.group.shop.mapper;

import com.group.shop.entity.Admin;
import com.group.shop.vo.AdminVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     * 根据id进行删除管理员
     * @param id
     * @return
     */
    int deleteAdminById(Integer id);

    /**
     * 插入管理员
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);

    int insertSelective(Admin admin);

    /**
     * 根据id进行查询
     * @param id
     * @return
     */
    Admin queryAdminById(Integer id);

    int updateByPrimaryKeySelective(Admin admin);

    /**
     * 更新admin
     * @param admin
     * @return
     */
    int updateAdmin(Admin admin);

    /**
     * 查询管理员
     * @param admin
     * @return
     */
    Admin queryAdminByAdmin(Admin admin);

    /**
     * 根据名字获取管理员
     * @param username
     * @return
     */
    Admin queryAdminByName(String username);

    /**
     * 查询列表
     * @param admin
     * @return
     */
    List<AdminVo> getAdminList(Admin admin);
}