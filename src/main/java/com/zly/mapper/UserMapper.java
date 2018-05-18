package com.zly.mapper;

import com.zly.pojo.User;
import com.zly.utils.MyMapper;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserMapper extends MyMapper<User> {

    @SelectProvider(type=UserSqlBulid.class,method = "findUserByUsernamePssword")
    public User loginUser(Map<String,String>map);

    @SelectProvider(type=UserSqlBulid.class,method = "findAllUser")
    public List<User> findAllUser ();

    @SelectProvider(type=UserSqlBulid.class,method = "registerUser")
    public User register(User user);
    class UserSqlBulid{
        public String findUserByUsernamePssword(Map<String,String>map){
            String sql = "select * from user";
            if (map.size()!=0){
                String username = (String)map.get("username");
                String password = (String)map.get("password");
                sql += " where username = #{username} and password = #{password}";
                System.out.print(sql);
            }
            return sql;
        }

        public String findAllUser(){
            return "select * from user";
        }

        public String registerUser(User user){
            Integer i = user.getId();
            String username = user.getUsername();
            String password = user.getPassword();
            String email = user.getEmail();
            String phoneNumber = user.getPhoneNumber();
            Date createTime = user.getCreateTime();
            String sql = "insert into user (id,username,password,phone_number,email,create_time,role_id) values (null,#{username},#{password},#{email},#{phoneNumber},#{createTime},1)";
            return sql;
        }
    }

}