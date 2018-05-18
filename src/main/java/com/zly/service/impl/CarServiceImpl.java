package com.zly.service.impl;

import com.zly.mapper.CarMapper;
import com.zly.mapper.UserMapper;
import com.zly.pojo.Car;
import com.zly.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/4/18.
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;

    public List<Car> findAllCar(Integer page){
        return carMapper.findAllCar(page);
    }

    @Override
    public int getCarConut() {
        return carMapper.getCarPage();
    }

    @Override
    public Car findCarById(Integer id) {
        return carMapper.findCarById(id);
    }
}
