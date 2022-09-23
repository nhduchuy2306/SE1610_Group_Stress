
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;


public interface UserDAO {
    User getAllUser();
    User getUserByEmail();
    User getUserByIDAndPassword(String userID, String password) throws SQLException;
    User getUserByEmail(String email) throws SQLException;
    User getUserByID();
    User getUserByUserName();
    boolean deleteUser(String userID) throws SQLException;
}
