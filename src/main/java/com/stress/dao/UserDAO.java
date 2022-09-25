/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.dao;

import com.stress.dto.GooglePojo;
import com.stress.dto.User;
import java.sql.SQLException;
import java.util.List;



public interface UserDAO {
    List<User> getAllUser() throws SQLException;
    User getUserByEmail(String email) throws SQLException;
    User getUserByIDAndPassword(String userID,String password) throws SQLException;
    boolean deleteUser(String userID) throws SQLException;
    boolean registerNewUSer(String userID,String userName,String password,String email,String DOB,String address,
        String phoneNumber,String sex) throws SQLException;
    boolean checkDuplicateByID(String userID) throws SQLException;
    User getUserByID(String userID) throws SQLException;
    boolean registerByEmail(GooglePojo googleUser) throws SQLException;
}
