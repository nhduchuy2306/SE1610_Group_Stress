
package com.stress.service;

import com.stress.dao.UserDAO;
import com.stress.dto.User;
import com.stress.utils.DBConnection;
import java.sql.Connection;
<<<<<<< HEAD
=======
import java.sql.Date;
>>>>>>> origin/quangtm
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDAOImpl implements UserDAO{
<<<<<<< HEAD
    private static final String LOGINBYEMAIL = "SELECT [userID], ";
    private static final String LOGIN="SELECT Username, Email,DOB, Address, PhoneNumber, Sex, RoleID, AccountBalance, Status FROM tblUsers WHERE UserID=? AND Password=?";
    private static final String DELETE="DELETE tblUsers WHERE UserID=?";
=======
<<<<<<< HEAD
    private static final String LOGINBYEMAIL="SELECT userID,username, dob, address, phoneNumber, sex, roleID, AccountBalance, status FROM tblUsers WHERE email=? AND password=?";
=======
    private static final String LOGIN_BY_EMAIL = "SELECT [UserID], [Username], [Password], [Address],[DOB], [PhoneNumber], [Sex], [RoleID], [AccountBalance]"
            + "  FROM tblUsers WHERE [Email] = ? AND [Status] = 1";
>>>>>>> origin/quangtm
>>>>>>> 56b46bbfd43a8eea4515d025c18345f493c84ff5
    
    @Override
    public User getAllUser() {
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
    public User getUserByEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    @Override
<<<<<<< HEAD
    public User getUserByIDAndPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
=======
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
                if(rs.next()) {
                    String userID = rs.getString("UserID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
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
>>>>>>> origin/quangtm
    }

    public User checkLogin(String email, String password) throws SQLException{
        User user=null;
        Connection conn=null;
        PreparedStatement ptm =null;
        ResultSet rs= null;
        try{
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs= ptm.executeQuery();
                if(rs.next()){
                    String username=rs.getString("username");
                    String email=rs.getString("email");
                    java.sql.Date dob =rs.getDate("dob");
                    String address=rs.getString("address");
                    String phoneNumber=rs.getString("phoneNumber");
                    boolean sex=rs.getBoolean("sex"); 
                    String roleID=rs.getString("roleID");
                    String AccountBalance=rs.getString("AccountBalance");
                    boolean status=rs.getBoolean("status");
                    user=new User(userID, username, password, email, dob, address, phoneNumber, sex, roleID, AccountBalance, status);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return user;
    }
    @Override
    public boolean deleteUser(String userID) throws SQLException{
        boolean result=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
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
