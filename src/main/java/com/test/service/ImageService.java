package com.test.service;

import com.test.entity.Image;

import java.util.List;


public interface ImageService {
    public List<Image> selectAll();
    public void insertOne(Image image);
}
