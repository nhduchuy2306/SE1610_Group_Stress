
package com.stress.service;

import com.stress.dao.TripDAO;
import com.stress.dto.Trip;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TripDAOImpl implements TripDAO{
    
    @Override
    public boolean deleteTrip(String tripID) throws SQLException {
        String sql = "DELETE FROM tblTrips WHERE TripID = ?";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, tripID);
            check = ptm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return check;
    }

    @Override
    public Trip getTripByID(String tripID) throws SQLException {
        String sql = "SELECT [TripID],[TripName], [StartDateTime],[Policy], RouteID, VehicleID, DriverID, SeatRemain, [Status]"
                + "WHERE TripID = ?";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, tripID);
            rs = ptm.executeQuery();
            while(rs.next()){
                return new Trip();
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return null;
    }
    
}
