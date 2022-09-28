package com.stress.service;

import com.stress.dao.LocationDAO;
import com.stress.dao.RouteDAO;
import com.stress.dto.Location;
import com.stress.dto.Route;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {
    
    private LocationDAO locationDao = new LocationDAOImpl();

    @Override
    public boolean deleteRoute(String routeID) throws SQLException {
        String sql = "UPDATE tblroutes SET [Status] = 0 WHERE [RouteID] = ?";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, routeID);
                check = ptm.executeUpdate() > 0;

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
    public boolean addRoute(Route route) throws SQLException {
        String sql = "INSERT INTO tblRoutes(RouteID,RouteName,"
                + "StartLocation,EndLocation,[Description],[Status]) VALUES(?,?,?,?,?,?)";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, route.getRouteID());
            ptm.setString(2, route.getRouteName());
            ptm.setInt(3, route.getStartLocation().getLocationID());
            ptm.setInt(4, route.getEndLocation().getLocationID());
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
        String sql = "UPDATE tblRoutes SET RouteName = ?, StartLocation = ?, "
                + "EndLocation = ?, [Description] = ?, [Status] = ? WHERE RouteID = ?";;
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, route.getRouteName());
            ptm.setInt(2, route.getStartLocation().getLocationID());
            ptm.setInt(3, route.getEndLocation().getLocationID());
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
    public List<Route> searchServiceByStartLocation(int startLocation) throws SQLException {
        Location locationByStart = locationDao.getLocationById(startLocation);
        
        String sql = "SELECT RouteID,RouteName,"
                    + "StartLocation,EndLocation,[Description],[Status] "
                    + "FROM tblRoutes "
                    + "WHERE StartLocation = ?";
        
        List<Route> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, "%" + startLocation + "%");
            rs = ptm.executeQuery();
            while (rs.next()) {
                Route route = new Route(rs.getInt("RouteID"), 
                        rs.getString("RouteName"), 
                        locationByStart, locationByStart, sql, true);
                list.add(route);
            }
        } catch (Exception e) {
        } finally {
            if (conn != null) conn.close();
            if (ptm != null) ptm.close();
            if (rs != null) rs.close();
        }
        return list;
    }

    @Override
    public List<Route> searchServiceByEndLocation(int endLocation) 
            throws SQLException {
        String sql = "select * \n"
            + "from tblRoutes\n"
            + "where EndLocation = (\n"
            + "	select LocationID \n"
            + "	from tblLocations \n"
            + "	where LocationName like ?\n"
            + ")";
        List<Route> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, "%" + endLocation + "%");
            rs = ptm.executeQuery();
            while (rs.next()) {
//                list.add(new Route(rs.getInt(1), 
//                        rs.getString(2), 
//                        rs.getInt(3), 
//                        rs.getInt(4), 
//                        rs.getString(5), 
//                        rs.getBoolean(6)));
            }
        } catch (Exception e) {
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    @Override
    public Route getRouteByID(String routeID) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
