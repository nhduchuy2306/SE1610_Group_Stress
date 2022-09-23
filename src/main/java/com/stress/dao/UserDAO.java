
package com.stress.dao;

import com.stress.dto.User;
import java.sql.SQLException;


public interface UserDAO {
    User getAllUser();
    User getUserByIDAndPassword();
    User getUserByEmail();
    User getUserByID();
    User getUserByUserName();
    boolean registerNewUSer(String userID,String userName,String password,String email,String DOB,String address,
        String phoneNumber,String sex)throws SQLException;
    boolean checkDuplicateByID(String userID) throws SQLException;
}
