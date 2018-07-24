package com.test.dao;

import com.test.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDao {
    public List<Image> selectAll();
    public void insertOne(Image image);
}
