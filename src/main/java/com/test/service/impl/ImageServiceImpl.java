package com.test.service.impl;

import com.test.dao.ImageDao;
import com.test.entity.Image;
import com.test.service.ImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    ImageDao imageDao;


    public List<Image> selectAll() {
        return  imageDao.selectAll();
    }

    public void insertOne(Image image) {
        imageDao.insertOne(image);
    }
}
