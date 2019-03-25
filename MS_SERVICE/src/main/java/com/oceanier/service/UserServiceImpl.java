package com.oceanier.service;

import com.oceanier.dao.UserDao;
import com.oceanier.entity.User;
import com.oceanier.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    public void deleteUserById(int id) {
        userDao.deleteUserById(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public List<User> queryUserByVo(UserVo userVo) {
        return userDao.queryUserByVo(userVo);
    }

    public User queryUserByAccount(String account) {
        return userDao.queryUserByAccount(account);
    }
}
