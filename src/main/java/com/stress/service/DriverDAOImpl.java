
package com.stress.service;

import com.stress.dao.DriverDAO;
import com.stress.dto.Driver;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DriverDAOImpl implements DriverDAO{
    
    private final String GET_ALL_DRIVER = "SELECT * FROM tblDriver";
    private final String ADD_NEW_DRIVER = "INSERT INTO tblDrivers(TripID,TripName,StartDateTime,"
            + "[Policy],RouteID,VehicleID,DriverID,SeatRemain,[Status] VALUES(?,?,?,?,?,?,?,?,?)";

    @Override
    public List<Driver> getAllDriver() throws SQLException{
        List<Driver> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(GET_ALL_DRIVER);
            rs = ptm.executeQuery();
            while(rs.next()){
                list.add(new Driver(
                        rs.getString(1), 
                        rs.getString(2), 
                        rs.getDate(3), 
                        rs.getString(4), 
                        rs.getString(5), 
                        rs.getInt(6)
                    ));
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return list;
    }

    @Override
    public boolean addNewDriver(Driver driver) {
        boolean check = false;
        return check;
    }
}
