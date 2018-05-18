package com.zly.service.impl;

import com.zly.mapper.CarImagesMapper;
import com.zly.mapper.CarMapper;
import com.zly.pojo.CarImages;
import com.zly.service.CarImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/4/23.
 */
@Service
public class CarImagesServiceImpl implements CarImagesService {

    @Autowired
    private CarImagesMapper carImagesMapper;
    @Override
    public List<CarImages> findCarImagesByCId(Integer cId){
        return carImagesMapper.findCarImagesBycId(cId);
    }

}
