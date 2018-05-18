package com.zly.mapper;

import com.zly.pojo.Car;
import com.zly.utils.MyMapper;
import org.apache.ibatis.annotations.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CarMapper extends MyMapper<Car> {

    @SelectProvider(type = carSqlBulid.class,method = "findAllCarByPage")
    @Results({
            @Result(
                    property = "carImages",
                    column = "title_images_url",
                    one = @One(select = "com.zly.mapper.CarImagesMapper.findCarImagesById")
            ),
            @Result(
                property = "store",
                    column = "s_id",
                    one = @One(select = "com.zly.mapper.StoreMapper.findStoreById")
            )
    })
    public List<Car> findAllCar(Integer page);


    @Select("select id,brand,name,p_year as pYear,mileage,s_id,price,title_images_url from car where id = #{id}")
    @Results({
            @Result(
                    property = "carImages",
                    column = "title_images_url",
                    one = @One(select = "com.zly.mapper.CarImagesMapper.findCarImagesById")
            ),
            @Result(
                    property = "store",
                    column = "s_id",
                    one = @One(select = "com.zly.mapper.StoreMapper.findStoreById")
            )
    })
    public Car findCarById(Integer id);
//    @Select("select * from car where is_sold_out=0")

    @Select("select count(*) from car where is_sold_out='0'")
    public Integer getCarPage();

//    @SelectProvider(type = carSqlBulid.class,method = "findCarById")
//    public Car findCarById(@Param(value = "id") Integer id);

    @Delete("delete from car where id=#{id}")
    public void delCarById(Integer id);

    @Update("update car set is_sold_out='1' where id=#{id} ")
    public void updCarIsSoldOut(Integer id);

    class carSqlBulid{

        public String findCarById(Integer id){
            String sql = "select * from car";
            if (id!=null){
                sql += " where id = #{id}";
            }
            return sql;
        }

        public String findAllCarByPage(Integer page){

            String sql = "select * from car";
            sql += "  where is_sold_out='0'";
            if (page<0){
                sql += "limit 0 ,20";
            }else{
                Integer pagesNum = 20;
                Integer staterPages = (page-1)*20;
                sql += " limit "+staterPages+","+pagesNum;
            }

            return sql;
        }
    }
}