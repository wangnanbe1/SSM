package com.test.controller;


import com.test.entity.Image;
import com.test.service.impl.ImageServiceImpl;
import com.test.vo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@ResponseBody
public class UploadImageController {


    @Resource
    ImageServiceImpl imageService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Result test(MultipartFile file, HttpServletRequest request){
        Result r = new Result();
        String path = request.getSession().getServletContext().getRealPath("/image");
        String fileName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));


        System.out.println("path:"+path+"------"+"fileName"+fileName);
        File fileDir = new File(path,newName);
        if(fileDir.exists()){
            fileDir.mkdirs();
        }
        try {
            file.transferTo(fileDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image i = new Image();
        long ii = System.currentTimeMillis();
        int a = (int)ii;
        i.setId(a);
        i.setName(newName);
        i.setPath("\\image\\"+newName);
        imageService.insertOne(i);

        r.setMsg("ok");
        r.setCode("200");

        return r;
    }

}
