package com.test.controller;


import com.test.entity.User;
import com.test.service.impl.UserServiceImpl;
import com.test.util.CreateImg;
import com.test.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@ResponseBody
public class UserLoginController {

    @Resource
    UserServiceImpl userService;


    @RequestMapping(value = "/verification",method= RequestMethod.GET)
    public void loginVerification(HttpServletRequest request, HttpServletResponse response){
        CreateImg ci = new CreateImg();
        try {
            ci.getImg(request,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/login2",method = RequestMethod.POST)
    public Result login(User user, HttpServletRequest request, HttpServletResponse response){
        Result r = new Result();
        User uu = userService.save(user.getName());
        HttpSession session = request.getSession();
        String attribute = (String) session.getAttribute("verificationCode");
        String parameter = request.getParameter("checkcode");


        if( attribute.equals(parameter)&& uu.getId().equals(user.getId())){
            r.setCode("200");
            r.setMsg("µÇÂ½³É¹¦!");
        }else {
            r.setCode("100");
            r.setMsg("µÇÂ½Ê§°Ü!");
        }

        return r;
    }


}
