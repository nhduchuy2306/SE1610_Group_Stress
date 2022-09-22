
package com.stress.service;

import com.stress.dao.RouteDAO;
import com.stress.dto.Route;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RouteDAOImpl implements RouteDAO{
    
    private static final String ADD_ROUTE = "INSERT INTO tblRoutes(RouteID,RouteName,"
            + "StartLocation,EndLocation,[Description],[Status]) VALUES(?,?,?,?,?,?)";
    private static final String UPDATE_ROUTE = "UPDATE tblRoutes SET RouteName = ?, StartLocation = ?, "
            + "EndLocation = ?, [Description] = ?, [Status] = ? WHERE RouteID = ?";
    
    private static final String DELETE_ROUTE = "UPDATE tblroutes SET [Status] = 0 WHERE [RouteID] = ?";
    
    @Override
    public boolean deleteRoute(String routeID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null) {
                ptm = conn.prepareStatement(DELETE_ROUTE);
                ptm.setString(1, routeID);
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
    public boolean addRoute(Route route) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(ADD_ROUTE);
            ptm.setString(1, route.getRouteID());
            ptm.setString(2, route.getRouteName());
            ptm.setString(3, route.getStartLocation());
            ptm.setString(4, route.getEndLocation());
            ptm.setString(5, route.getDescription());
            ptm.setBoolean(6, route.isStatus());
            check = ptm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return check;
    }

    @Override
    public boolean updateRoute(Route route) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(UPDATE_ROUTE);
            ptm.setString(1, route.getRouteName());
            ptm.setString(2, route.getStartLocation());
            ptm.setString(3, route.getEndLocation());
            ptm.setString(4, route.getDescription());
            ptm.setBoolean(5, route.isStatus());
            ptm.setString(6, route.getRouteID());
            check = ptm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }
        return check;
    }
    
}
