package com.zly.controller;

import com.zly.pojo.CarImages;
import com.zly.service.CarImagesService;
import com.zly.service.CarService;
import com.zly.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zly11 on 2018/4/23.
 */
@RestController
public class CarImagesController {

    @Autowired
    private CarImagesService carImagesService;

    @RequestMapping("carImages/getCarImages")
    public JsonResult getCarImagesByCId(HttpServletRequest request){
        Integer cId = Integer.valueOf(request.getParameter("carId"));
        return JsonResult.ok(carImagesService.findCarImagesByCId(cId));
    }
}
