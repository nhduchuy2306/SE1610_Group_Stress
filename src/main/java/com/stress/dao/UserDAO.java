
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;
import java.util.List;


public interface UserDAO {
    List<User> getAllUser() throws SQLException;

    User getUserByIDAndPassword();

    User getUserByEmail(String email) throws SQLException;

    User getUserByEmail();

    User getUserIDAndPassword();
    

    User getUserByID();
    User getUserByUserName(); 
}
