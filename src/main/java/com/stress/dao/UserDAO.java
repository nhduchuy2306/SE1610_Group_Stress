
package com.stress.dao;

import com.stress.dto.User;


public interface UserDAO {
    User getAllUser();
    User getUserIDAndPassword();
    User getUserByID();
    User getUserByUserName();
}
