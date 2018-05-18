package com.zly.controller;

import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.gimpy.FishEyeGimpyRenderer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.zly.mapper.UserMapper;
import com.zly.pojo.AuthCode;
import com.zly.pojo.TokenModel;
import com.zly.pojo.User;
import com.zly.service.TokenService;
import com.zly.service.UserService;
import com.zly.utils.AuthCodeUtils;
import com.zly.utils.DaomainUtils;
import com.zly.utils.JsonResult;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.session.Session;
import org.springframework.web.bind.annotation.*;
import sun.org.mozilla.javascript.internal.Token;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.UUID;


/**
 * Created by zly11 on 2018/4/3.
 */
@RestController
public class UserController {

    private static int captchaExpires = 3*60; //超时时间3min
    private static int captchaW = 200;
    private static int captchaH = 60;
    private static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;



    //生成二维码
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @RequestMapping("login/loginUser")
    public JsonResult login(@RequestBody String userMassage,HttpServletRequest request){


        JSONObject jsonObject = JSONObject.fromObject(userMassage);
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        //String authCode = jsonObject.getString("authCode");

// if ( sessionAuthCode == null|| sessionAuthCode.equals(authCode)){
//            return JsonResult.authCodeError();
//        }
        if (userService.loginUser(username,password)!=null){
            String token = tokenService.createToken(jsonObject.getString("username"));
            return JsonResult.ok(new TokenModel(username,token));
        }else{
            return JsonResult.exitUser();
        }

    }

//    @RequestMapping("check/authCode")
//    private  @ResponseBody byte[] getAutoCode( HttpServletRequest request, HttpServletResponse response){
//
//        String uuid = UUID.randomUUID().toString();
//        Captcha captcha = new Captcha.Builder(captchaW, captchaH)
//                .addText().addBackground(new GradiatedBackgroundProducer())
//                .gimp(new FishEyeGimpyRenderer())
//                .build();
//
//        //tokenService.createAuthCode(uuid,captcha.getAnswer());
//
//
//        ByteArrayOutputStream bao = new ByteArrayOutputStream();
//        try {
//            ImageIO.write(captcha.getImage(), "png", bao);
//
//            return bao.toByteArray();
//        }catch (IOException e){
//            return null;
//        }
//
//    }

    /**
     * 生成验证码
     * @param username
     * @param response
     * @return
     */
    @PostMapping("check/isLogin")
    public JsonResult checkLogin(@RequestBody String username,HttpServletResponse response){
        //response.setHeader("Access-Control-Allow-Origin","*");
        JSONObject jsonObject = JSONObject.fromObject(username);
        String username1 = jsonObject.getString("username");

        if (tokenService.selectToken(username1) != null){
            return JsonResult.ok();
        }else{
            return JsonResult.noLogin();
        }
    }
    @PostMapping("register/userRegister")
    public JsonResult register(@RequestBody String registerMassage){
        JSONObject jsonObject = JSONObject.fromObject(registerMassage);
        User user1 = new User();
        User user = (User)DaomainUtils.JsonToDaomain(user1,jsonObject);
        return JsonResult.ok( userService.register(user));
    }

    //@PreAuthorize()
    @GetMapping("api/mi/findAllUser")
    public JsonResult findAllUser() {
        return JsonResult.ok(userService.findAllUser());
    }

    @PostMapping("mi/logOut")
    public JsonResult loginOut(HttpServletRequest request){
        String username = request.getParameter("username");
        tokenService.deleteToken(username);
        return JsonResult.ok("注销成功");
    }




}
