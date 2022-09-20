/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.dto;

import java.util.Date;


/**
 *
 * @author Huy
 */
public class Order {
    private String orderID;
    private Date createDate;
    private String paymentMode;
    private User user;
    private boolean status;

    public Order() {
    }

    public Order(String orderID, Date createDate, String paymentMode, User user, boolean status) {
        this.orderID = orderID;
        this.createDate = createDate;
        this.paymentMode = paymentMode;
        this.user = user;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", createDate=" + createDate + ", paymentMode=" + paymentMode + ", user=" + user + ", status=" + status + '}';
    }
    
    
}
