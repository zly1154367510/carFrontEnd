package com.zly.mapper;

import com.zly.pojo.ShappingCar;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ShappingCarMapper extends MyMapper<ShappingCar> {

    @SelectProvider(type = ShappingCarMapperSqlBulid.class,method = "addShappingCar")
    public ShappingCar addShappingCar(Map<String,Object> map);

    @SelectProvider(type = ShappingCarMapperSqlBulid.class,method = "findAllShappingCarByUsername")
    public List<ShappingCar> findAllShappingCarByUsername(Map<String,Object>map);

    @Select("select " +
            "id," +
            "car_id as carId," +
            "username," +
            "is_pay as isPay," +
            "create_time as createTime " +
            "from shapping_car where username=#{username}")
    @Results({
            @Result(
                    property = "car",
                    column = "carId",
                    one = @One(select = "com.zly.mapper.CarMapper.findCarById")
            )
    })
    public List<ShappingCar> findShappingCarByUsername(String username);



    @Delete("delete from shapping_car where id=#{id}")
    public void deleteShappingCarById(Integer id);

    @Update("update shapping_car set is_pay='1' where id=#{id}")
    public void updIsPay(Integer id);

    class ShappingCarMapperSqlBulid{

        public String findAllShappingCarByUsername(Map<String,Object> map){
            String username = (String)map.get("username");
            // String ShappingCarId = (String)map.get("ShappingCarId");
            String sql = "select id,car_id as carId,username,is_pay as isPay,create_time as createTime from shapping_car where username=#{username}";
            return sql;
        }
        public String addShappingCar(Map<String,Object> map){
            String carId = (String) map.get("carId");
            String username = (String) map.get("username");
            Date createTime = (Date) map.get("createTime");
            String sql = "insert into shapping_car (id,car_id,username,is_pay,create_time) values (null,#{carId},#{username},'0" +
                    "',#{createTime})";
            return sql;
        }

    }
}