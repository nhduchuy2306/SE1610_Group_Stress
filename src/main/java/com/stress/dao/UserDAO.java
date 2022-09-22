
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;


public interface UserDAO {
    User getAllUser();
<<<<<<< HEAD
    User getUserByIDAndPassword();
    User getUserByEmail();
=======
    User getUserIDAndPassword();
    User getUserByEmail(String email) throws SQLException;
>>>>>>> origin/quangtm
    User getUserByID();
    User getUserByUserName(); 
}
