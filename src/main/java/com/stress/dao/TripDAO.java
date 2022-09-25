
package com.stress.dao;

import com.stress.dto.Trip;
import java.sql.SQLException;


public interface TripDAO {
    boolean deleteTrip(String tripID) throws SQLException;
    Trip getTripByID(String tripID) throws SQLException;
}
