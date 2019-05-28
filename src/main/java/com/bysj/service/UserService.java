package com.bysj.service;

import com.bysj.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @Time 9:43
 */
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    List<User> getUserList();

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User toLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 验证用户名唯一
     * @param username
     * @return
     */
    User getByUserName(String username);

    /**
     * 验证邮箱唯一
     * @param email
     * @return
     */
    User getByEmail(String email);

    /**
     * 验证手机号码唯一
     * @param phone
     * @return
     */
    User getByPhone(String phone);

    /**
     * 查询单个信息
     * @param id
     * @return
     */
    User getByUserId(Integer id);

    /**
     * 添加用户
     * @param user
     * @return
     */
    Integer insertUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    Integer deleteUser(Integer id);

    /**
     * 修改用户信息密码除外
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 单独修改密码
     * @param user
     * @return
     */
    Integer updatePassword(User user);
}
