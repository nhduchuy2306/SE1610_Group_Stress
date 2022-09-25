
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;
import java.util.List;


public interface IUser {
    User getAllUser();
    User getUserByIDAndPassword();
    User getUserByEmail();
    User getUserByID();
    User getUserByUserName();
    User getUserByEmail(String email) throws SQLException;
    User getUserByIDAndPassword(String userID,String password) throws SQLException;
    boolean deleteUser(String userID) throws SQLException;
    boolean registerNewUSer(String userID,String userName,String password,String email,String DOB,String address,String phoneNumber,String sex) throws SQLException;
    boolean checkDuplicateByID(String userID) throws SQLException;
}
