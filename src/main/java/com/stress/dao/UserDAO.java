
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;
import java.util.List;


public interface UserDAO {

    List<User> getAllUser() throws SQLException;


    User getUserByIDAndPassword();

    User getUserByEmail(String email) throws SQLException;



    User getUserIDAndPassword();
    User getUserByEmail(String email) throws SQLException;

    User getUserByID();
    User getUserByUserName();
    boolean registerNewUSer(String userID,String name,String password,String email,String roleID,boolean status)throws SQLException;
    boolean checkDuplicateByID(String userID) throws SQLException;
}
