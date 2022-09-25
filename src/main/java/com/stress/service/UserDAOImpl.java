package com.stress.service;

import com.stress.dao.RoleDAO;
import com.stress.dao.UserDAO;
import com.stress.dto.GooglePojo;
import com.stress.dto.Role;
import com.stress.dto.User;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private RoleDAO roleDAO = new RoleDAOImpl(); // DONT REMOVE this is use for get User by ID 
    
    private static final String GET_ALL_USER = "SELECT [UserID],[UserName],[Password], [Email], [DOB], [Address], [PhoneNumber],"
            + " [Sex],[RoleID], [AccountBalance], [Status] FROM tblUsers WHERE [status] = 1 OR [Status] = 2";
    private static final String LOGIN = "SELECT [Username], [Email],[DOB], [Address], [PhoneNumber], [Sex], [RoleID], [AccountBalance], [Status] "
            + "FROM tblUsers WHERE [UserID]=? AND [Password]=?";
    
    private static final String LOGIN_BY_EMAIL = "SELECT [UserID], [Username], [RoleID] "
            + "  FROM tblUsers WHERE [Email] = ? AND [Status] = ?";
    private static final String CHECK_DUPLICATE = "SELECT userID,username, DOB, address, phoneNumber, sex, roleID, AccountBalance, status FROM tblUsers WHERE userID=?";

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
                    String phoneNumber =rs.getString("PhoneNumber");
                    String email = rs.getString("Email");
                    boolean sex = rs.getBoolean("Sex");
                    String roleID = rs.getString("RoleID");
                    String AccountBalance = rs.getString("AccountBalance");
                    int status = rs.getInt("Status");
                                        
                    Role role = new RoleDAOImpl().getRoleByID(roleID);
                    if(role != null)
                    userList.add(new User(userID, username, password, email, dob, address, phoneNumber, sex, role, AccountBalance, status));
                }
            }

        } catch (Exception e) {
            System.out.println("Error at getAllUser:" +e.toString());
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
                ptm.setInt(2, User.ACTIVE_GOOGLE);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String userID = rs.getString("UserID");
                    String username = rs.getString("Username");
                    String roleID = rs.getString("RoleID");
                    
                    Role role = new RoleDAOImpl().getRoleByID(roleID);
                    if(role != null)
                    user = new User(userID, username, null, email, null, null, null, true, role, null, User.ACTIVE_GOOGLE);
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
    public User getUserByIDAndPassword(String userID, String password) throws SQLException {
        User user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
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
        String delete = "UPDATE tblUsers SET [status]=0  WHERE UserID=?";
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(delete);
                ptm.setString(1, userID);
                result = ptm.executeUpdate()> 0 ? true : false;
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
    public boolean registerNewUSer(String userID,String userName,String password,String email,String DOB,String address,
        String phoneNumber,String sex) throws SQLException {
            String register="INSERT INTO tblUsers(UserID,Username,[Password]"
                     + ",Email,DOB,[Address],PhoneNumber,Sex,RoleID,AccountBalance,[Status]) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm =null;
        try {
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(register);
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
            }
        } catch (Exception e) {
            System.out.println("Error at registerNewUSer:"+ e.toString());
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
            conn=DBConnection.getConnection();
            if(conn!=null){
                ptm=conn.prepareStatement(CHECK_DUPLICATE);
                ptm.setString(1, userID);
                rs=ptm.executeQuery();
                if(rs!=null){
                    check=true;
                }
            }
        }catch(Exception e){
            System.out.println("Error at checkDuplicateByID:"+ e.toString());
        }finally{
            if(rs!=null)rs.close();
            if(ptm!=null)ptm.close();
            if(conn!=null)conn.close();
        }
        return check; 
    }
    @Override
    public User getUserByID(String userID) throws SQLException {
        String sql = "SELECT [UserID],[UserName],[Password], [Email], [DOB], [Address], [PhoneNumber],"
            + " [Sex],[RoleID], [AccountBalance], [Status] FROM tblUsers WHERE [UserID] = ?";
        Connection conn =null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        RoleDAO roleDAO=new RoleDAOImpl();
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, userID);
            rs = ptm.executeQuery();
            while(rs.next()){
                return new User(rs.getString("UserID"),
                                rs.getString("Username"),
                                rs.getString("Password"),
                                rs.getString("Email"),
                                rs.getDate("DOB"),
                                rs.getString("DOB"),
                                rs.getString("PhoneNumber"),
                                rs.getBoolean("Sex"),
                                roleDAO.getRoleByID(userID),
                                rs.getString("AccountBalance"),
                                rs.getInt("Status")
                            );
            }
        } catch (Exception e) {
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return null;
    }   
    @Override
    public boolean registerByEmail(GooglePojo googleUser) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("INSERT INTO tblUsers([UserID], [Username], [Email], [Status],[RoleID], [Password]) VALUES (?,?,?,?,?,?)");
                ptm.setString(1, googleUser.getId());
                ptm.setString(2, googleUser.getName());
                ptm.setString(3, googleUser.getEmail());
                ptm.setInt(4, User.ACTIVE_GOOGLE);
                ptm.setInt(5, 1);
                ptm.setString(6, "123");
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
    
    public static void main(String[] args) {
        try {
            UserDAOImpl dao=new UserDAOImpl();
            boolean check=dao.deleteUser("chu be dan 9");
            System.out.println("check:" +check);
        } catch (Exception e) {
        }
    }
}
