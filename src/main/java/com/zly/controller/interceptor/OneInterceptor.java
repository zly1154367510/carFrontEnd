package com.zly.controller.interceptor;

import com.zly.service.TokenService;
import com.zly.service.impl.TokenServiceImpl;
import com.zly.utils.JsonResult;
import com.zly.utils.JsonUtils;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.org.mozilla.javascript.internal.Token;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by zly11 on 2018/4/2.
 */
public class OneInterceptor implements HandlerInterceptor {
    @Resource
    private TokenService tokenService;
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("经过密码验证");

        String username = httpServletRequest.getParameter("username");
//        String username =   httpServletRequest.getHeader("username");;
        String token = httpServletRequest.getParameter("token");
        String token1 = tokenService.selectToken(username);
        if (!token.equals(token1) || token == null) {
            System.out.println("未登录");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                JSONObject jsonObject = JSONObject.fromObject(JsonResult.noLogin());
                out = httpServletResponse.getWriter();
                out.write(jsonObject.toString());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            return true;
        }
        return false;
    }
}
