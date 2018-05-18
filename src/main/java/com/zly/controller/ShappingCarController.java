package com.zly.controller;

import com.zly.pojo.ShappingCar;
import com.zly.service.ShappingService;
import com.zly.service.UserService;
import com.zly.utils.JsonResult;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/4/21.
 */

@RestController
public class ShappingCarController {


    @Autowired
    private ShappingService shappingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "mi/addShoppingCar")
    public JsonResult addShoppingCar(HttpServletResponse response, HttpServletRequest request){
        Date date = new Date();
        System.out.println(request.getParameter("username"));
        shappingService.addShappingCar(request.getParameter("carId"),request.getParameter("username"),date);
        return JsonResult.ok("添加购物车成功");
    }

    @RequestMapping("mi/getShappingCarList")
    public JsonResult getShappingCarList(HttpServletRequest request){
        String username = request.getParameter("username");
        List<ShappingCar> list = shappingService.findAllShappingCarByUsername(username);
        return JsonResult.ok(list);
    }

    @RequestMapping("mi/goPay")
    public JsonResult goPay(HttpServletRequest request){
        String sId = request.getParameter("sId");
        String cId = request.getParameter("cId");
        shappingService.payShappingCar(Integer.valueOf(sId),Integer.valueOf(cId));
        return JsonResult.ok();

    }

    @RequestMapping("mi/delShappingCar")
    public JsonResult delShappingCar(HttpServletRequest request){
        String sId = request.getParameter("sId");
        //System.out.println("request数据:"+sId);
        shappingService.delShappingCar(Integer.valueOf(sId));
        return JsonResult.ok();
    }

}
