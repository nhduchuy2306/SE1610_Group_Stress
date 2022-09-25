package com.stress.service;

import com.stress.dao.RouteDAO;
import com.stress.dto.Route;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {

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
    

    private static final String SERVICE_BY_START_LOCATION = "select * \n"
                                + "from tblRoutes\n"
                                + "where StartLocation = (\n"
                                + "	select LocationID \n"
                                + "	from tblLocations \n"
                                + "	where LocationName like ?\n"
                                + ")";
    private static final String SERVICE_BY_END_LOCATION = "select * \n"
                                + "from tblRoutes\n"
                                + "where EndLocation = (\n"
                                + "	select LocationID \n"
                                + "	from tblLocations \n"
                                + "	where LocationName like ?\n"
                                + ")";
    
  


    @Override
    public boolean addRoute(Route route) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(ADD_ROUTE);
            ptm.setInt(1, route.getRouteID());
            ptm.setString(2, route.getRouteName());
//            ptm.setInt(3, route.getStartLocation().get);
//            ptm.setInt(4, route.getEndLocation());
            ptm.setString(5, route.getDescription());
            ptm.setBoolean(6, route.isStatus());
            check = ptm.executeUpdate() > 0;
        } catch (Exception e) {
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
    public boolean updateRoute(Route route) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(UPDATE_ROUTE);
            ptm.setString(1, route.getRouteName());
//            ptm.setInt(2, route.getStartLocation());
//            ptm.setInt(3, route.getEndLocation());
            ptm.setString(4, route.getDescription());
            ptm.setBoolean(5, route.isStatus());
            ptm.setInt(6, route.getRouteID());
            check = ptm.executeUpdate() > 0;
        } catch (Exception e) {
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
    public List<Route> searchServiceByStartLocation(String startLocation) throws SQLException {
        List<Route> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(SERVICE_BY_START_LOCATION);
            ptm.setString(1, "%"+startLocation+"%");
            rs = ptm.executeQuery();
            while(rs.next()){
//                list.add(new Route(rs.getInt(1), 
//                        rs.getString(2), 
////                        rs.getInt(3), 
//                        rs.getInt(4), 
//                        rs.getString(5), 
//                        rs.getBoolean(6)));
            }
        } catch (Exception e) {
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return list;
    }

    @Override
    public List<Route> searchServiceByEndLocation(String endLocation) throws SQLException {
        List<Route> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(SERVICE_BY_END_LOCATION);
            ptm.setString(1, "%"+endLocation+"%");
            rs = ptm.executeQuery();
            while(rs.next()){
//                list.add(new Route(rs.getInt(1), 
//                        rs.getString(2), 
//                        rs.getInt(3), 
//                        rs.getInt(4), 
//                        rs.getString(5), 
//                        rs.getBoolean(6)));
            }
        } catch (Exception e) {
        } finally {
            if(conn!=null) conn.close();
            if(ptm!=null) ptm.close();
            if(rs!=null) rs.close();
        }
        return list;
    }

    @Override
    public Route getRouteByID(String routeID) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
