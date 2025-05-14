package com.example.PackageDelivery.DTO;

import com.example.PackageDelivery.Enumeration.Status;

import java.util.Date;

public class PackageDTO{
    private Integer id;
    private Date createdOn;

    private Integer payOnDelivery;
    private String packageName;


    public Integer getPayOnDelivery() {
        return payOnDelivery;
    }

    public void setPayOnDelivery(Integer payOnDelivery) {
        this.payOnDelivery = payOnDelivery;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public PackageDTO(Integer id, Date createdOn, String deliveryAddress, Status status, Integer courierId, Integer payOnDelivery, String packageName) {
        this.id = id;
        this.createdOn = createdOn;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
        this.courierId = courierId;
        this.payOnDelivery = payOnDelivery;
        this.packageName = packageName;
    }

    private String deliveryAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    private Status status;
    private Integer courierId;

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public void setCourierId(Integer courierId) {
        this.courierId = courierId;
    }
}
