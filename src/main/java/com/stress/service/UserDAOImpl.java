package com.stress.service;

import com.stress.dao.UserDAO;
import com.stress.dto.Role;
import com.stress.dto.User;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


<<<<<<< HEAD
public class UserDAOImpl implements UserDAO{
    private static final String LOGINBYEMAIL="SELECT userID,username, dob, address, phoneNumber, sex, roleID, AccountBalance, status FROM tblUsers WHERE email=? AND password=?";
    private static final String REGITER="INSERT INTO tblUsers(UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE="SELECT userID,username, DOB, [Address], phoneNumber, sex, roleID, AccountBalance,[Status] FROM tblUsers WHERE userID=?";
    
    @Override
    public User getAllUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
=======
public class UserDAOImpl implements UserDAO {
    private static final String GET_ALL_USER = "SELECT [UserID],[UserName],[Password], [Email], [DOB], [Address], [PhoneNumber],"
            + " [Sex],[RoleID], [AccountBalance], [Status] FROM tblUsers WHERE [status] = 1 OR [Status] = 2";
    private static final String LOGIN = "SELECT [Username], [Email],[DOB], [Address], [PhoneNumber], [Sex], [RoleID], [AccountBalance], [Status] "
            + "FROM tblUsers WHERE [UserID]=? AND [Password]=?";
    private static final String DELETE = "DELETE tblUsers WHERE UserID=?";
    private static final String LOGIN_BY_EMAIL = "SELECT [UserID], [Username], [Password], [Address],[DOB], [PhoneNumber], [Sex], [RoleID], [AccountBalance]"
            + "  FROM tblUsers WHERE [Email] = ? AND [Status] = 1";
    private static final String REGITER = "INSERT INTO tblUsers(UserID,Username,[Password],Email,RoleID,[Status]) VALUES (?,?,?,?,?,?)";
    private static final String CHECK_DUPLICATE = "SELECT userID,username, DOB, address, phoneNumber, sex, roleID, AccountBalance, status FROM tblUsers WHERE userID=?";
>>>>>>> 6d94466080c1eb1ce6c24352fb80f46686ef20a1

    @Override
    public List<User> getAllUser() throws SQLException {
        List<User> userList = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_ALL_USER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("UserID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    Date dob = rs.getDate("DOB");
                    String address = rs.getString("Address");
                    String phoneNumber = rs.getString("PhoneNumber");
                    String email = rs.getString("Email");
                    boolean sex = rs.getBoolean("Sex");
                    String roleID = rs.getString("RoleID");
                    String AccountBalance = rs.getString("AccountBalance");
                    int status = rs.getInt("Status");
                    
                    ptm = conn.prepareStatement("SELECT RoleName FROM tblRoles WHERE RoleID = ?");
                    ptm.setString(1, roleID);
                    rs1 = ptm.executeQuery();
                    Role role = null;
                    if(rs1.next()) {
                        String roleName = rs.getString("roleName");
                        role = new Role(roleID, roleName);
                    }
                    
                    userList.add(new User(userID, username, password, email, dob, address, phoneNumber, sex, role, AccountBalance, status));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs1 != null) rs.close();
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
        return userList;
    }

    @Override
    public User getUserByEmail(String email) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN_BY_EMAIL);
                ptm.setString(1, email);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String userID = rs.getString("UserID");
                    String username = rs.getString("Username");
                    String password = rs.getString("Password");
                    Date DOB = rs.getDate("DOB");
                    String address = rs.getString("Address");
                    String phoneNumber = rs.getString("PhoneNumber");
                    boolean sex = rs.getBoolean("Sex");
                    String roleID = rs.getString("RoleID");
                    String AccountBalance = rs.getString("AccountBalance");
//                    user = new User(userID, username, password, email, DOB, address, phoneNumber, sex, roleID, AccountBalance, true);
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
        return user;
    }

    @Override
<<<<<<< HEAD
    public boolean registerNewUSer(String userID,String userName,String password,String email,String DOB,String address,
        String phoneNumber,String sex) throws SQLException  {
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm =null;
=======
    public User getUserByIDAndPassword(String userID, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
>>>>>>> 6d94466080c1eb1ce6c24352fb80f46686ef20a1
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userID);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    java.sql.Date dob = rs.getDate("dob");
                    String address = rs.getString("address");
                    String phoneNumber = rs.getString("phoneNumber");
                    boolean sex = rs.getBoolean("sex");
                    String roleID = rs.getString("roleID");
                    Float AccountBalance = rs.getFloat("AccountBalance");
                    String tmpAccountBalance = Float.toString(AccountBalance);
                    boolean status = rs.getBoolean("status");
//                    user = new User(userID, username, password, email, dob, address, phoneNumber, sex, roleID, tmpAccountBalance, status);
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
        return user;
    }

    @Override
    public boolean deleteUser(String userID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, userID);
                result = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    @Override

    public boolean registerNewUSer(String userID, String name, String password, String email, String roleID, boolean status) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(REGITER);
                ptm.setString(1, userID);
                ptm.setString(2, userName);
                ptm.setString(3, password);
                ptm.setString(4, email);
<<<<<<< HEAD
                ptm.setString(5, DOB);
                ptm.setString(6, address);
                ptm.setString(7, phoneNumber);
                ptm.setString(8, sex);
                ptm.setString(9, "1");
                ptm.setDouble(10, 0);
                ptm.setBoolean(11, true);
                check=ptm.executeUpdate()>0? true:false;
           //     UserID,Username,[Password],Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]
=======
                ptm.setString(5, roleID);
                ptm.setBoolean(6, status);
                check = ptm.executeUpdate() > 0 ? true : false;
>>>>>>> 6d94466080c1eb1ce6c24352fb80f46686ef20a1
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    public boolean checkDuplicateByID(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs = ptm.executeQuery();
                if (rs != null) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
<<<<<<< HEAD
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
=======

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

>>>>>>> 6d94466080c1eb1ce6c24352fb80f46686ef20a1
}
