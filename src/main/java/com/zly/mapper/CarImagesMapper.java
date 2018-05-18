package com.zly.mapper;

import com.zly.pojo.Car;
import com.zly.pojo.CarImages;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CarImagesMapper extends MyMapper<CarImages> {

    @Select("select images_url as imagesUrl from car_images where id = #{id}")
    public CarImages findCarImagesById(Integer id);


    @Select("select images_url as imagesUrl from car_images where c_id = #{cId}")
    public List<CarImages> findCarImagesBycId(Integer cId);
}