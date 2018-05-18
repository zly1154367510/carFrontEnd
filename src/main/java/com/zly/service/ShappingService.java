package com.zly.service;

import com.zly.pojo.ShappingCar;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/4/21.
 */
@Service
public interface ShappingService {

    public ShappingCar addShappingCar(String carId,String UserId,Date date);

    public List<ShappingCar> findAllShappingCarByUsername(String username);


    public void payShappingCar(Integer sId,Integer cId);

    public void delShappingCar(Integer sId);
}
