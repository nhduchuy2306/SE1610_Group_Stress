
package com.stress.dao;

import com.stress.dto.Driver;
import java.sql.SQLException;
import java.util.List;


public interface DriverDAO {
    List<Driver> getAllDriver() throws SQLException;
    boolean addNewDriver(Driver driver);
}
