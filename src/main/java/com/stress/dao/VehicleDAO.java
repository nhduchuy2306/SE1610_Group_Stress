
package com.stress.dao;

import java.sql.SQLException;
import java.util.List;
import com.stress.dto.Vehicle;


public interface VehicleDAO {
    boolean deleteVehicle(String VehicleID) throws SQLException;
    boolean createVehicle(Vehicle vehicle) throws SQLException;
    boolean updateVehicle(Vehicle vehicle) throws SQLException;
    List<Vehicle> getVehicleByName(String search) throws SQLException;
    List<Vehicle> getAllVehicle() throws SQLException;
}
