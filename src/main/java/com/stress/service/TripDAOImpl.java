
package com.stress.service;

import com.stress.dao.TripDAO;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class TripDAOImpl implements TripDAO{
    
    private static final String DELETE_TRIP = "DELETE FROM tblTrips WHERE TripID = ?";

    @Override
    public boolean deleteTrip(String tripID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(DELETE_TRIP);
            ptm.setString(1, tripID);
            check = ptm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return check;
    }
    
}
