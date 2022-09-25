
package com.stress.dao;
import com.stress.dto.VehicleType;
import java.sql.SQLException;
import java.util.List;


public interface VehicleTypeDAO {
    public List<VehicleType> getAllVehicleType() throws SQLException;
    public boolean createVehicleType(VehicleType newVehicleType) throws SQLException;
    public boolean updateVehicleType(VehicleType updateVehicleType) throws SQLException;
    public boolean deleteVehicleType(VehicleType deleteVehicleType) throws  SQLException;
    
}
