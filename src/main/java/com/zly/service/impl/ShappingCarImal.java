package com.zly.service.impl;

import com.zly.mapper.CarMapper;
import com.zly.mapper.ShappingCarMapper;
import com.zly.pojo.ShappingCar;
import com.zly.service.CarService;
import com.zly.service.ShappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zly11 on 2018/4/21.
 */
@Service
public class ShappingCarImal implements ShappingService {

    @Autowired
    private ShappingCarMapper shappingCarMapper;

    @Autowired
    private CarMapper carMapper;
    @Override
    public ShappingCar addShappingCar(String carId, String username,Date date) {
        System.out.println(username);
        Map<String,Object> map = new HashMap<>();
        map.put("carId",carId);
        map.put("username",username);
        map.put("createTime",date);
        shappingCarMapper.addShappingCar(map);
        return null;
    }

    @Override
    public List<ShappingCar> findAllShappingCarByUsername(String username) {
     //   System.out.println("个体");
        return shappingCarMapper.findShappingCarByUsername(username);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void payShappingCar(Integer sId, Integer cId) {
       // System.out.println("事务");
        shappingCarMapper.updIsPay(sId);
        carMapper.updCarIsSoldOut(cId);
    }

    @Override
    public void delShappingCar(Integer sId) {
        shappingCarMapper.deleteShappingCarById(sId);
    }
}
