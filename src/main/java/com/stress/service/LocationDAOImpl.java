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
    public Location getLocationById(int locationID) throws SQLException {
        String getLocationById = "SELECT [LocationID],[LocationName],[CityID] FROM tblLocations WHERE [locationID]=?";
        Location loc = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getLocationById);
                ptm.setInt(1, locationID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String locationName = rs.getString("LocationName");
                    String address = rs.getString("Address");
                    int cityID = rs.getInt("CityID");
                    boolean status = rs.getBoolean("Status");
                    loc = new Location(locationID, locationName,address,cityID,status);
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
    public Location getLocationByName(String locationName) throws SQLException {
        String getLocationByName = "SELECT [LocationID],[LocationName],[Address],[CityID],[Status] FROM tblLocations WHERE [LocationName]=?";
        Location loc = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getLocationByName);
                ptm.setString(1, locationName);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int locationID = rs.getInt("LocationID");
                    String address = rs.getString("Address");
                    int cityID = rs.getInt("CityID");
                    boolean status = rs.getBoolean("Status");
                    loc = new Location(locationID, locationName,address,cityID,status);
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
        String getAllLocation = "SELECT [LocationID],[LocationName],[Address],[CityID],[Status] FROM tblLocations";
        List<Location> locationList = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getAllLocation);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int locationID = rs.getInt("LocationID");
                    String locationName = rs.getString("LocationName");
                    String address = rs.getString("Address");
                    int CityID = rs.getInt("CityID");
                    boolean status = rs.getBoolean("status");
                    locationList.add(new Location(locationID, locationName,address,CityID,status));
                }
            }

        } catch (Exception e) {
            System.out.println("Error at getAllLocation:" + e.toString());
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
        return locationList;
    }
    @Override
    public List<Location> searchLocation(String search) throws SQLException {
        String SEARCH = "SELECT [locationID],[LocationName],[Address], [CityID],[Status] FROM tblLocations WHERE [LocationName] like ?";
        List<Location> locationList = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%"+search+"%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int locationID = rs.getInt("LocationID");
                    String locationName = rs.getString("LocationName");
                    String address = rs.getString("Address");
                    int cityID = rs.getInt("CityID");
                    boolean status = rs.getBoolean("status");
                    locationList.add(new Location(locationID, locationName,address,cityID,status));
                }
            }

        } catch (Exception e) {
            System.out.println("Error at getAllLocation:" + e.toString());
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
        return locationList;
    }
    @Override
    public boolean addLocation(int locationID, String locationName,String address,int cityID,boolean status) throws SQLException {
        String add="INSERT INTO tblLocations ([LocationID],[LocationName],[Address],[CityID],[Status]) VALUES (?,?,?,?,?)";
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm =null;
        try {
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(add);
                ptm.setInt(1, locationID);
                ptm.setString(2, locationName);
                ptm.setString(3,address );
                ptm.setInt(4, cityID);
                ptm.setBoolean(5, status );
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
    @Override
    public boolean checkDuplicateByID(int locationId) throws SQLException{
        String checkDuplicate = "SELECT [locationID] FROM tblLocations WHERE [locationID]=?";
        boolean check = true;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(checkDuplicate);
                ptm.setInt(1, locationId);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return check;
    }
    @Override
    public boolean addLocation(Location location) throws SQLException {
        String register="INSERT INTO tblLocations ([LocationID],[LocationName],[Address],[CityID],[Status]) VALUES (?,?,?,?,?)";
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm =null;
        try {
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(register);
                ptm.setInt(1, location.getLocationID());
                ptm.setString(2, location.getLocationName());
                ptm.setString(3, location.getAddress());
                ptm.setInt(4, location.getCityID());
                ptm.setBoolean(5, location.isStatus());
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
    @Override
    public boolean deleteLocation(String locationID) throws SQLException{
        String DELETE="UPDATE tblLocations SET [Status]= 0  WHERE LocationID=?";
        boolean result=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(DELETE);
                int tmp=Integer.parseInt(locationID);
                ptm.setInt(1,tmp);
                result=ptm.executeUpdate()>0? true:false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return result;
    }
    @Override
    public boolean updateLocation(Location location) throws SQLException{
        String UPDATE = "UPDATE tblLocations SET [LocationName] = ?,[Address] = ?,[CityID] = ?,[Status] = ? WHERE [locationID] = ?";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, location.getLocationName());
                ptm.setString(2, location.getAddress());
                ptm.setInt(3, location.getCityID());
                ptm.setBoolean(4, location.isStatus());
                ptm.setInt(5, location.getLocationID());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return check;
    }
}
