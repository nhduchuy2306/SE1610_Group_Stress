
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
import java.util.logging.Level;
import java.util.logging.Logger;



public class DriverDAOImpl implements DriverDAO{
    
    @Override
    public List<Driver> getAllDriver() throws SQLException{
        String sql = "SELECT [DriverID],[DriverName],[DOB],[Sex],[DriverPic],[PhoneNumber],[Status] FROM tblDrivers";
        List<Driver> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            rs = ptm.executeQuery();
            while(rs.next()){
                list.add(new Driver(
                        rs.getString("DriverID"), 
                        rs.getString("DriverName"), 
                        rs.getDate("DOB"), 
                        rs.getBoolean("Sex"), 
                        rs.getString("DriverPic"), 
                        rs.getString("PhoneNumber"), 
                        rs.getInt("Status")
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
    public boolean addNewDriver(Driver driver) throws SQLException{
        String sql = "INSERT INTO tblDrivers([DriverID],[DriverName],[DOB],[Sex],[DriverPic],[PhoneNumber],[Status]) "
                + "VALUES(?,?,?,?,?,?,?)";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1,driver.getDriverID());
            ptm.setString(2, driver.getDriverName());
            ptm.setDate(3, driver.getDOB());
            ptm.setBoolean(4, driver.isSex());
            ptm.setString(5, driver.getDriverPicture());
            ptm.setString(6, driver.getPhoneNumber());
            ptm.setInt(7, driver.getStatus());
            check = ptm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return check;
    }
    
    @Override
    public boolean deleteDriver(String DriverID) throws SQLException{
        String sql = "DELETE tblDrivers WHERE [DriverID]=?";
        boolean result=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(sql);
                ptm.setString(1, DriverID);
                result=ptm.executeUpdate()>0;
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
    public boolean updateDriver(Driver driver) throws SQLException {
        String sql = "UPDATE tblDrivers "
                + "SET [DriverName] = ?, [DOB] = ?, [Sex] = ?, [DriverPic] = ?, [PhoneNumber] = ?, [Status] = ? "
                + "WHERE DriverID=?";
        boolean result=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(sql);
                ptm.setString(1, driver.getDriverName());
                ptm.setDate(2, driver.getDOB());
                ptm.setBoolean(3, driver.isSex());
                ptm.setString(4, driver.getDriverPicture());
                ptm.setString(5, driver.getPhoneNumber());
                ptm.setInt(6, driver.getStatus());
                ptm.setString(7, driver.getDriverID());
                result=ptm.executeUpdate()>0;
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
    public Driver getDriverByID(String driverID) throws SQLException {
        String sql = "SELECT [DriverID],[DriverName],[DOB],[Sex],[DriverPic],[PhoneNumber],[Status] "
                    + "FROM tblDrivers "
                    + "WHERE [DriverID] = ?";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, driverID);
            rs = ptm.executeQuery();
            while(rs.next()){
                return new Driver(
                        rs.getString("DriverID"), 
                        rs.getString("DriverName"), 
                        rs.getDate("DOB"), 
                        rs.getBoolean("Sex"), 
                        rs.getString("DriverPic"), 
                        rs.getString("PhoneNumber"), 
                        rs.getInt("Status")
                    );
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return null;
    }

}
