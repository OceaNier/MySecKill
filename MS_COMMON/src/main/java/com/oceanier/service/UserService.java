package com.oceanier.service;

import com.oceanier.entity.User;
import com.oceanier.vo.user.UserVo;

import java.util.List;

public interface UserService {


    public void insertUser(User user);

    public User queryUserById(int id);

    public void deleteUserById(int id);

    public void updateUser(User user);

    public List<User> queryUserByVo(UserVo userVo);

    public User queryUserByAccount(String account);
}
