package com.stress.service;

import com.stress.dao.LocationDAO;
import com.stress.dto.Location;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocationDAOImpl implements LocationDAO {

    @Override
    public Location getLocationById(int LocationId) throws SQLException {
        String getLocationById = "SELECT [LocationID],[LocationName] FROM tblLocations WHERE [LocationId]=?";
        Location loc = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getLocationById);
                ptm.setInt(1, LocationId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String LocationName = rs.getString("LocationName");
                    loc = new Location(LocationId, LocationName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getLocationById:" + e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return loc;
    }

    @Override
    public Location getLocationByName(String LocationName) throws SQLException {
        String getLocationByName = "SELECT [LocationID],[LocationName] FROM tblLocations WHERE [LocationName]=?";
        Location loc = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getLocationByName);
                ptm.setString(1, LocationName);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int LocationID = rs.getInt("LocationID");
                    loc = new Location(LocationID, LocationName);
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getLocationByName:" + e.toString());
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return loc;
    }

    @Override
    public List<Location> getAllLocation() throws SQLException {
        String getAllLocation = "SELECT [LocationID],[LocationName] FROM tblLocations";
        List<Location> locationList = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getAllLocation);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int LocationID = rs.getInt("LocationID");
                    String LocationName = rs.getString("LocationName");
                    locationList.add(new Location(LocationID, LocationName));
                }
            }

        } catch (Exception e) {
            System.out.println("Error at getAllLocation:" + e.toString());
        } finally {
            if (rs1 != null) {
                rs.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return locationList;
    }
    @Override
    public List<Location> searchLocation(String search) throws SQLException {
        String SEARCH = "SELECT [LocationID],[LocationName] FROM tblLocations WHERE [LocationName] like ?";
        List<Location> locationList = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%"+search+"%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int LocationID = rs.getInt("LocationID");
                    String LocationName = rs.getString("LocationName");
                    locationList.add(new Location(LocationID, LocationName));
                }
            }

        } catch (Exception e) {
            System.out.println("Error at getAllLocation:" + e.toString());
        } finally {
            if (rs1 != null) {
                rs.close();
            }
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return locationList;
    }
    @Override
    public boolean addLocation(int locationID, String locationName) throws SQLException {
        String register="INSERT INTO tblLocations ([LocationID],[LocationName]) VALUES (?,?)";
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm =null;
        try {
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(register);
                ptm.setInt(1, locationID);
                ptm.setString(2, locationName);
                check=ptm.executeUpdate()>0? true:false;         
            }
        } catch (Exception e) {
            System.out.println("Error at addLocation:"+ e.toString());
        }finally{
            if(ptm!=null)ptm.close();
            if(conn!=null)conn.close();
        }
        return check;
    }
}
