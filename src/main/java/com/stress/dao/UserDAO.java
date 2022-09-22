
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;


public interface UserDAO {
    User getAllUser();
    User getUserIDAndPassword();
    User getUserByEmail();
    User getUserByID();
    User getUserByUserName();
    User checkLogin(String email, String password) throws SQLException;
    boolean deleteUser(String userID) throws SQLException;
}
