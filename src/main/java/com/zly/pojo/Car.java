package com.zly.pojo;

import javax.persistence.*;

public class Car {
    @Id
    private Integer id;

    private String brand;

    private String name;

    @Column(name = "is_sold_out")
    private String isSoldOut;

    @Column(name = "p_year")
    private String pYear;

    private String mileage;

    @Column(name = "d_id")
    private Integer dId;

    @Column(name = "s_id")
    private Integer sId;

    private String price;

    @Column(name="title_images_url")
    private CarImages carImages;

    @Column(name="s_id")
    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public CarImages getCarImages() {
        return carImages;
    }

    public void setCarImages(CarImages carImages) {
        this.carImages = carImages;
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
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return p_year
     */
    public String getpYear() {
        return pYear;
    }

    /**
     * @param pYear
     */
    public void setpYear(String pYear) {
        this.pYear = pYear;
    }

    /**
     * @return mileage
     */
    public String getMileage() {
        return mileage;
    }

    /**
     * @param mileage
     */
    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    /**
     * @return d_id
     */
    public Integer getdId() {
        return dId;
    }

    /**
     * @param dId
     */
    public void setdId(Integer dId) {
        this.dId = dId;
    }

    /**
     * @return s_id
     */
    public Integer getsId() {
        return sId;
    }

    /**
     * @param sId
     */
    public void setsId(Integer sId) {
        this.sId = sId;
    }

    /**
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsSoldOut() {
        return isSoldOut;
    }

    public void setIsSoldOut(String isSoldOut) {
        this.isSoldOut = isSoldOut;
    }
}