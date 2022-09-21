
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;


public interface UserDAO {
    User getAllUser();
    User getUserIDAndPassword();
    User getUserByEmail(String email) throws SQLException;
    User getUserByID();
    User getUserByUserName();
}
