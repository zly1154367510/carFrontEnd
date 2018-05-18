package com.zly.service;

import com.zly.pojo.CarImages;

import java.util.List;

/**
 * Created by zly11 on 2018/4/23.
 */
public interface CarImagesService {

    List<CarImages> findCarImagesByCId(Integer cId);
}
