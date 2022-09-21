
package com.stress.dao;

import java.sql.SQLException;


public interface TripDAO {
    boolean deleteTrip(String tripID) throws SQLException;
}
