package com.zly.pojo;

import javax.persistence.*;

public class Store {
    @Id
    private Integer id;

    private String username;

    private String password;

    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "legal_person")
    private String legalPerson;

    @Column(name = "images_url")
    private String imagesUrl;

    @Column(name = "is_audit")
    private String isAudit;

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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return legal_person
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * @param legalPerson
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
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
     * @return is_audit
     */
    public String getIsAudit() {
        return isAudit;
    }

    /**
     * @param isAudit
     */
    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit;
    }
}