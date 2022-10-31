/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.dao;

import com.stress.dto.Coupon;
import com.stress.dto.UserCoupon;
import java.sql.SQLException;
import java.util.List;
public interface CouponDAO {
    List<Coupon> getAllCoupon(String day)throws SQLException;
    boolean deleteCoupon(String couponID)throws SQLException;
    boolean updateCoupon(Coupon coupon)throws SQLException;
    boolean addCoupon(int count,int percent,String exDate,String exTime)throws SQLException;
    Coupon getNewCoupon()throws SQLException;
    Coupon getCouponByPercent(int percent) throws SQLException;
    Coupon getCouponByID(int couponID) throws SQLException;
    boolean insertUserCoupon(String userID,String couponID)throws SQLException;
    boolean setNumOfCoupon(String couponID,int count)throws SQLException;
    UserCoupon getUserCoupon(String userID,String couponID)throws SQLException;
    boolean setStatusUserCoupon(String userID,String couponID,int status)throws SQLException;
}
