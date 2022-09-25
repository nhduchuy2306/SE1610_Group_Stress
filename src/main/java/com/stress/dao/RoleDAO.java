
package com.stress.dao;

import java.sql.SQLException;
import com.stress.dto.Role;


public interface RoleDAO {
    public Role getRoleByID(String roleID) throws SQLException;
}
