package com.zly.utils;

import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Action;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zly11 on 2018/4/21.
 */
public class AuthCodeUtils {


    @Autowired
    private
    static Map<String, Object> codeMap;

    //2.创建char数组保存验证码出现字符
    private static char[] codeSequence = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    //3.创建常量规定验证码图片和图片中字符位置
    private static final int IMAGESWIDTH = 200;
    private static final int IMAGESHEIGHT = 50;
    private static final int STRINGPOSITIONWIDTH = 45;
    private static final int STRINGPOSITIONHEIGHT = 35;
    private static int fontHeight = 18;

    public static Map<String, Object> GenerateVerificationCodeImages() {
        //5.实例化保存验证码字符和图片map对象
        codeMap = new HashMap<String, Object>();

        //6.创建BufferedImage图片缓冲区对象
        BufferedImage bi = new BufferedImage(IMAGESWIDTH, IMAGESHEIGHT, BufferedImage.TYPE_INT_RGB);

        //7.创建Graphics对象
        Graphics graphics = bi.createGraphics();

        //8.规定背景颜色
        graphics.setColor(Color.GREEN);

        //8.设置字体
        graphics.fillRect(0, 0, IMAGESWIDTH, IMAGESHEIGHT);

        Font font = new Font("Fixedsys", Font.BOLD, fontHeight);

        graphics.setFont(font);

        //9.创建BufferString对象存储随机数
        StringBuffer randomCode = new StringBuffer();

        //10.创建随机数对象
        Random random = new Random();

        //11.设置验证码字符颜色
        graphics.setColor(Color.RED);

        //12.生成随机数 渲染graphics对象
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(35);
            randomCode.append(codeSequence[index]);
            graphics.drawString(codeSequence[index] + "", STRINGPOSITIONWIDTH * i, STRINGPOSITIONHEIGHT);
        }

        //13.生成随机线条渲染Graphics
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(IMAGESWIDTH);
            int y = random.nextInt(IMAGESHEIGHT);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            graphics.drawLine(x, y, x + xl, y + yl);
        }

        //14.图片验证码储存进map对象
        codeMap.put("codeString", randomCode.toString());
        codeMap.put("codeImages", bi);

        return codeMap;

    }
}
