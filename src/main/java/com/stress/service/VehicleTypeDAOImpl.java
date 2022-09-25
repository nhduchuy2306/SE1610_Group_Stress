/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.service;

import com.stress.dao.VehicleTypeDAO;
import com.stress.dto.VehicleType;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhQuang
 */
public class VehicleTypeDAOImpl implements VehicleTypeDAO {

    
    @Override
    public List<VehicleType> getAllVehicleType() throws SQLException {
        List<VehicleType> vehicleTypeList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("SELECT [VehicleTypeID], [VehicleTypeName],[TotalSeat] FROM tblVehicleTypes");
                rs = ptm.executeQuery();
                while(rs.next()) {
                    int vehicleTypeID = rs.getInt("vehicleTypeID");
                    String vehicleTypeName = rs.getString("VehicleTypeName");
                    int totalSeat = rs.getInt("totalSeat");
                    vehicleTypeList.add(new VehicleType(vehicleTypeID, vehicleTypeName, totalSeat));
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) rs.close();
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return vehicleTypeList;
    }

    @Override
    public boolean createVehicleType(VehicleType newVehicleType) throws SQLException {
         boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("INSERT INTO tblVehicleTypes(VehicleTypeName, TotalSeat) VALUES(?, ?)");
                ptm.setString(1, newVehicleType.getVehicleTypeName());
                ptm.setInt(2, newVehicleType.getTotalSeat());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return check;
    }
    

    @Override
    public boolean updateVehicleType(VehicleType updateVehicleType) throws SQLException {
                 boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("UPDATE tblVehicleTypes SET VehicleTypeName = ?, TotalSeat = ? WHERE [VehicleTypeID] = ?");
                ptm.setString(1, updateVehicleType.getVehicleTypeName());
                ptm.setInt(2, updateVehicleType.getTotalSeat());
                ptm.setInt(3, updateVehicleType.getVehicleTypeID());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        return check;
    }

    @Override
    public boolean deleteVehicleType(VehicleType deleteVehicleType) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("DELETE FROM tblVehicleTypes WHERE [VehicleTypeID] = ?");
                ptm.setInt(1, deleteVehicleType.getVehicleTypeID());
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
