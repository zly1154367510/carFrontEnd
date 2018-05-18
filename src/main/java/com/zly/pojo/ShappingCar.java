package com.zly.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "shapping_car")
public class ShappingCar {
    @Id
    private Integer id;

    @Column(name = "car_id")
    private Integer carId;

    private String username;

    @Column(name = "is_pay")
    private String isPay;

    @Column(name = "create_time")
    private Date createTime;

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return car_id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return is_pay
     */
    public String getIsPay() {
        return isPay;
    }

    /**
     * @param isPay
     */
    public void setIsPay(String isPay) {
        this.isPay = isPay;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}