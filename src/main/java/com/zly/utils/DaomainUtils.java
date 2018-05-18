package com.zly.utils;

import net.sf.json.JSONObject;
import sun.rmi.transport.ObjectTable;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zly11 on 2018/4/20.
 */
public class DaomainUtils {

    public static Object JsonToDaomain(Object t, JSONObject jsonObject){
        try {

            Object o = t.getClass().newInstance();
            Field[] fields = t.getClass().getDeclaredFields();
            String s;
            for (Field f:fields){
                if (f.getName().equals("id")){
                    continue;
                }else if (f.getGenericType().toString().equals("class java.util.Date") ){
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = format1.parse(jsonObject.getString(f.getName()));
                    f.setAccessible(true);
                    f.set(o, date);
                }else{
                    System.out.println(f.getGenericType().toString());
                    f.setAccessible(true);
                    s = jsonObject.getString(f.getName());
                    f.set(o, s);
                }

            }
            return o;
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.getErrorOffset();
        }

        return null;
    }
}
