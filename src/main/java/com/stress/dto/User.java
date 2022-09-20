/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.dto;

import java.sql.Date;

/**
 *
 * @author Huy
 */
public class User {
    private String userID;
    private String username;
    private String password;
    private String email;
    private Date dob;
    private String address;
    private String phoneNumber;
    private boolean sex;
    private Role role;
    private String AccountBalance;
    private boolean status;

    public User() {
    }

    public User(String userID, String username, String password, String email, Date dob, String address, String phoneNumber, boolean sex, Role role, String AccountBalance, boolean status) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.role = role;
        this.AccountBalance = AccountBalance;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(String AccountBalance) {
        this.AccountBalance = AccountBalance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + ", email=" + email + ", dob=" + dob + ", address=" + address + ", phoneNumber=" + phoneNumber + ", sex=" + sex + ", role=" + role + ", AccountBalance=" + AccountBalance + ", status=" + status + '}';
    }
    
    
}
