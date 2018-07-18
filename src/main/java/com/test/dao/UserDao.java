package com.test.dao;

import com.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao {
    public List<User> selectAll();
    public User save(String name);
}
