/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.service;

import com.stress.dao.DriverLicenseDAO;
import com.stress.dto.Driver;
import com.stress.dto.DriverLicense;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MinhQuang
 */
public class DriverLicenseDAOImpl implements DriverLicenseDAO {

    @Override
    public List<DriverLicense> getAllDriverLicense() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DriverLicense getDriverLicenseByID(String licenseID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        DriverLicense dl = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("SELECT [nationality], [Class],[DateExpired],[DriverID] FROM tblDriverLicenses WHERE "
                        + " [DriverLicenseID] = ?");
                ptm.setString(1, licenseID);
                rs = ptm.executeQuery();
                if(rs.next()) {
                    String nationality = rs.getString("nationality");
                    String classes = rs.getString("Classes");
                    Date dateExpired = rs.getDate("DateExpired");
                    String driverID = rs.getString("driverID");
                    Driver d = new DriverDAOImpl().getDriverByID(driverID);
                    if(d != null) {
                        dl = new DriverLicense(licenseID, nationality, classes, dateExpired, d);
                    }else {
                        throw  new Exception("Driver Not Found Exception");
                    }
                } 
            }
            
        } catch (Exception e) {
        } finally {
            if(rs != null) rs.close();
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return dl;
    }

    @Override
    public boolean deleteDriverLicense(String driverLicenseID) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("DELETE FROM tblDriverLicenses WHERE DriverLicenseID = ?");
                ptm.setString(1, driverLicenseID);
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return check;
    }

    @Override
    public boolean createDriverLicense(DriverLicense dl) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("INSERT INTO tblDriverLicenses([DriverLicenseID],[Nationality],[Class],[DateExpired],[DriverID]) "
                        + " VALUES(?,?,?,?,?)");
                ptm.setString(1, dl.getDriverLicenseID());
                ptm.setString(2, dl.getNationality());
                ptm.setString(3, dl.getClasses());
                ptm.setDate(4, dl.getDateExpired());
                ptm.setString(5, dl.getDriver().getDriverID());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return check;
    }

    @Override
    public boolean updateDriverLicense(DriverLicense dl) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("UPDATE tblVehicleLicenses SET [Nationality] = ?, [DateExpired] = ?, [Class] = ? WHERE [DriverLicenseID] = ?");
                ptm.setString(1, dl.getNationality());
                ptm.setDate(2, dl.getDateExpired());
                ptm.setString(3, dl.getClasses());
                ptm.setString(4, dl.getDriverLicenseID());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return check;
    }
    
}
