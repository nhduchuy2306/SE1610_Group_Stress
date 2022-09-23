
package com.stress.dao;

import java.sql.SQLException;


public interface VehicleDAO {
    boolean deleteVehicle(String VehicleID) throws SQLException;
}
