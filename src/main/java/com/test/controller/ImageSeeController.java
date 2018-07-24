package com.test.controller;


import com.test.entity.Image;
import com.test.service.impl.ImageServiceImpl;
import com.test.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@ResponseBody
public class ImageSeeController {

    @Resource
    ImageServiceImpl imageService;


    @RequestMapping(value = "/see",method = RequestMethod.POST)
    public Result ImageSee(){
        Result r = new Result();
        List<Image> images = imageService.selectAll();
        Image image = images.get(0);
        String path = image.getPath();
        r.setMsg(path);
        r.setCode("200");

        return r;
    }
}
