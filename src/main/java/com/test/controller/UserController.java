package com.test.controller;


import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
public class UserController {

    @Resource
    UserServiceImpl userService;

    @RequestMapping(value="/login",method= RequestMethod.POST)
    public List<User> selectAll(){
        return userService.selectAll();
    }


}
