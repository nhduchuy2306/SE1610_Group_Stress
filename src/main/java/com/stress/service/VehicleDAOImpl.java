
package com.stress.service;

import com.stress.dao.VehicleDAO;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class VehicleDAOImpl implements VehicleDAO {
    private static final String DELETE="DELETE tblVehicles WHERE VehicleID=?";
    @Override
    public boolean deleteVehicle(String VehicleID) throws SQLException{
        boolean result=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(DELETE);
                ptm.setString(1, VehicleID);
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
}
