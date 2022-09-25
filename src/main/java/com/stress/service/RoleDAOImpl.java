/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.service;

import com.stress.dao.RoleDAO;
import java.sql.SQLException;
import com.stress.dto.Role;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MinhQuang
 */
public class RoleDAOImpl implements RoleDAO {
    @Override 
    public Role getRoleByID(String roleID) throws SQLException {
        Role role = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement("SELECT [roleName] FROM tblRoles WHERE [RoleID] = ?");
                ptm.setString(1, roleID);
                rs = ptm.executeQuery();
                if(rs.next()) {
                    role = new Role(roleID, rs.getString("RoleName"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs != null) rs.close();
            if(ptm != null) ptm.close();
            if(conn != null) conn.close();
        }
        
        
        return role;
    }
}
