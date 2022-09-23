
package com.stress.service;

import com.stress.dao.DriverDAO;
import com.stress.dto.Driver;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DriverDAOImpl implements DriverDAO{
    
    private final String GET_ALL_DRIVER = "SELECT * FROM tblDriver";
    private final String ADD_NEW_DRIVER = "INSERT INTO tblDrivers(DriverID,DriverName,DOB,"
            + "Sex,DriverPic,PhoneNumber,[Status] VALUES(?,?,?,?,?,?,?)";
    private static final String DELETE="DELETE tblDrivers WHERE DriverID=?";

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
                        rs.getBoolean(4), 
                        rs.getString(5), 
                        rs.getString(6), 
                        rs.getInt(7)
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
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(ADD_NEW_DRIVER);
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
        boolean result=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(DELETE);
                ptm.setString(1, DriverID);
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
