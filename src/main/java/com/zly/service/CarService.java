package com.zly.service;

import com.zly.pojo.Car;

import java.util.List;

/**
 * Created by zly11 on 2018/4/18.
 */
public interface CarService {

    List<Car> findAllCar(Integer page);

    int getCarConut();

    Car findCarById(Integer id);
}
