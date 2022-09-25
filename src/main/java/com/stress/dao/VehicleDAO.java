
package com.stress.dao;

import com.stress.dto.Vehicle;
import java.sql.SQLException;


public interface VehicleDAO {
    boolean deleteVehicle(String VehicleID) throws SQLException;
    Vehicle getVehicleByID(String vehicleID) throws SQLException;
}
