package com.test.service.impl;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    UserDao userDao;

    public List<User> selectAll() {

       return userDao.selectAll();
    }

    public User save(String name) {

        return  userDao.save( name);
    }
}
