
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;
import java.util.List;


public interface UserDAO {
    User getAllUser();
    User getUserByIDAndPassword();
    User getUserByEmail();
    User getUserByID();
    User getUserByUserName();
    boolean registerNewUSer(String userID,String userName,String password,String email,String DOB,String address,
    String phoneNumber,String sex)throws SQLException;
    User getUserByEmail(String email) throws SQLException;
    User getUserByIDAndPassword(String userID,String password) throws SQLException;
    boolean deleteUser(String userID) throws SQLException;
    boolean registerNewUSer(String userID,String name,String password,String email,String roleID,boolean status)throws SQLException;
    boolean checkDuplicateByID(String userID) throws SQLException;
}
