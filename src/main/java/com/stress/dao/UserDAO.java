
package com.stress.dao;

import com.stress.dto.User;


public interface UserDAO {
    User getAllUser();
    User getUserByIDAndPassword();
    User getUserByEmail();
    User getUserByID();
    User getUserByUserName(); 
}
