package com.zly.pojo;

import javax.persistence.*;

@Table(name = "car_images")
public class CarImages {
    @Id
    private Integer id;

    @Column(name = "d_id")
    private Integer dId;

    @Column(name = "images_url")
    private String imagesUrl;

    @Column(name = "c_id")
    private Integer cId;

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
     * @return images_url
     */
    public String getImagesUrl() {
        return imagesUrl;
    }

    /**
     * @param imagesUrl
     */
    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    /**
     * @return c_id
     */
    public Integer getcId() {
        return cId;
    }

    /**
     * @param cId
     */
    public void setcId(Integer cId) {
        this.cId = cId;
    }
}