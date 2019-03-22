package com.oceanier.dao;

import com.oceanier.entity.User;
import com.oceanier.vo.user.UserVo;

import java.util.List;

public interface UserDao {

    void insertUser(User user);

    User queryUserById(int id);

    void deleteUserById(int id);

    void updateUser(User user);

    List<User> queryUserByVo(UserVo userVo);

    User queryUserByAccount(String account);
}
