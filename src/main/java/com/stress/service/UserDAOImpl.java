
package com.stress.service;

import com.stress.dao.UserDAO;
import com.stress.dto.User;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO{
    private static final String LOGIN_BY_EMAIL = "SELECT [userID], [Username], [Password], [Address],[DOB], [PhoneNumber], [Sex], [RoleID], [AccountBalance]"
            + "  FROM tblUsers WHERE [Email] = ? AND [Status] = 1";
    
    @Override
    public User getAllUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getUserIDAndPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getUserByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getUserByUserName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        User loginUser = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement(LOGIN_BY_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if(rs != null) {
                    String userID = rs.getString("UserID");
                    String username = rs.getString("Username");
                    String password = rs.getString("password");
                    Date DOB = rs.getDate("DOB");
                    String address = rs.getString("Address");
                    String phoneNumber = rs.getString("PhoneNumber");
                    boolean sex = rs.getBoolean("sex");
                    String roleID = rs.getString("roleID");
                    float accountBalance = rs.getFloat("AccountBalance");
                    loginUser = new User(userID, username, password, email, DOB, address, phoneNumber, sex, roleID, accountBalance, sex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) rs.close();
            if(ptm != null) ptm.close();
            if(rs != null) rs.close();
        }
        return loginUser;
    }
    
}
