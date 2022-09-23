
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;


public interface UserDAO {
    User getAllUser();
    User getUserByIDAndPassword();
    User getUserByEmail();
    User getUserIDAndPassword();
    User getUserByEmail(String email) throws SQLException;
    User getUserByID();
    User getUserByUserName();
    boolean registerNewUSer(String userID,String name,String password,String email,String roleID,boolean status)throws SQLException;
    boolean checkDuplicateByID(String userID) throws SQLException;
}
