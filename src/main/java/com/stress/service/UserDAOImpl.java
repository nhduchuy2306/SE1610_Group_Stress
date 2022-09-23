
package com.stress.service;

import com.stress.dao.UserDAO;
import com.stress.dto.User;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UserDAOImpl implements UserDAO{
    private static final String LOGINBYEMAIL="SELECT userID,username, dob, address, phoneNumber, sex, roleID, AccountBalance, status FROM tblUsers WHERE email=? AND password=?";
    private static final String REGITER="INSERT INTO tblUsers(UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE="SELECT userID,username, DOB, [Address], phoneNumber, sex, roleID, AccountBalance,[Status] FROM tblUsers WHERE userID=?";
    
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
    public User getUserByIDAndPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public User checkLogin(String email, String password) throws SQLException{
        User user=null;
        Connection conn=null;
        PreparedStatement ptm =null;
        ResultSet rs= null;
        try{
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(LOGINBYEMAIL);
                ptm.setString(1, email);
                ptm.setString(2, password);
                rs= ptm.executeQuery();
                if(rs.next()){
                    String userID=rs.getString("userID");
                    String username=rs.getString("username");
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
    public boolean registerNewUSer(String userID,String userName,String password,String email,String DOB,String address,
        String phoneNumber,String sex) throws SQLException  {
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm =null;
        try {
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(REGITER);
                ptm.setString(1, userID);
                ptm.setString(2, userName);
                ptm.setString(3, password);
                ptm.setString(4, email);
                ptm.setString(5, DOB);
                ptm.setString(6, address);
                ptm.setString(7, phoneNumber);
                ptm.setString(8, sex);
                ptm.setString(9, "1");
                ptm.setDouble(10, 0);
                ptm.setBoolean(11, true);
                check=ptm.executeUpdate()>0? true:false;
           //     UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(ptm!=null)ptm.close();
            if(conn!=null)conn.close();
        }
        return check;
    }

    @Override
    public boolean checkDuplicateByID(String userID) throws SQLException {
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm =null;
        ResultSet rs= null;
        try{
            conn=conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs=ptm.executeQuery();
                if(rs!=null){
                    check=true;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null)rs.close();
            if(ptm!=null)ptm.close();
            if(conn!=null)conn.close();
        }
        return check;
    }
    public static void main(String[] args) {
        try {
            UserDAOImpl dao=new UserDAOImpl();
            Date date=new Date(12,2,3);
          
            boolean check=dao.checkDuplicateByID("nangchoichang");
            System.out.println("check:"+check);
        } catch (Exception e) {
        }
    }
}
