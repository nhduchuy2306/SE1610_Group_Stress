
package com.stress.dao;

import com.stress.dto.Location;
import java.sql.SQLException;


public interface LocationDAO {
    Location getLocationById(int locationId) throws SQLException;
    Location getLocationByName(String location) throws SQLException;
}
