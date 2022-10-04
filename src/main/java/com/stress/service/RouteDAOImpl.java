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
    public boolean updateRoute(int RouteID, String RouteName, Location StartLocation, Location EndLocation, String Description, boolean Status) throws SQLException {
        String sql = "UPDATE tblRoutes SET RouteName = ?, StartLocation = ?, "
                + "EndLocation = ?, [Description] = ?, [Status] = ? WHERE RouteID = ?";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, RouteID);
            ptm.setString(2, RouteName);
            ptm.setString(3, Integer.toString(StartLocation.getLocationID()));
            ptm.setString(4, Integer.toString(EndLocation.getLocationID()));
            ptm.setString(5, Description);
            ptm.setString(6, Boolean.toString(Status));
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
    public Route getRouteByID(int routeID) throws SQLException {
        String sql = "SELECT RouteID,RouteName,"
                + "StartLocation,EndLocation,[Description],[Status] "
                + "FROM tblRoutes "
                + "WHERE RouteID = ?";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if(conn != null){
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, routeID);
                rs = ptm.executeQuery();
                if(rs.next()){
                    return new Route(rs.getInt("RouteID"), 
                            rs.getString("RouteName"), 
                            locationDao.getLocationById(rs.getInt("StartLocation")), 
                            locationDao.getLocationById(rs.getInt("EndLocation")), 
                            rs.getString("Description"), rs.getBoolean("Status"));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        }
        return null;
    }

    @Override
    public boolean checkDuplicateByID(int routeID) throws SQLException {
        String checkDuplicate = "SELECT routeID FROM tblRoutes WHERE routeID=?";
        boolean check = true;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(checkDuplicate);
                ptm.setInt(1, routeID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    check = false;
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
        return check;
    }

    @Override
    public List<Route> getAllRoute() throws SQLException {
        String getAllRoute = "SELECT [RouteID],[RouteName],[StartLocation], [EndLocation], [Description], [Status] FROM tblRoutes WHERE [Status] = 1 OR [Status] = 2";
        List<Route> routeList = new ArrayList();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(getAllRoute);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int RouteID = rs.getInt("RouteID");
                    String RouteName = rs.getString("RouteName");
                    int tmpStartLocation = rs.getInt("StartLocation");
                    int tmpEndLocation = rs.getInt("EndLocation");
                    String Description = rs.getString("Description");
                    int tmpStatus = rs.getInt("Status");
                    //Convert
                    LocationDAO LDAO = new LocationDAOImpl();
                    Location StartLocation = LDAO.getLocationById(tmpStartLocation);
                    Location EndLocation = LDAO.getLocationById(tmpEndLocation);
                    String tmp=Integer.toString(tmpStatus);
                    boolean Status=Boolean.parseBoolean(tmp);
                    routeList.add(new Route(RouteID, RouteName, StartLocation, EndLocation, Description, Status));
                }
            }
        } catch (Exception e) {
            System.out.println("Error at getAllUser:" + e.toString());
        } finally {
            if (rs1 != null) {
                rs.close();
            }
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
        return routeList;
    }

    @Override
    public List<Route> getAllActiveRoute() throws SQLException {
        List<Route> list = new ArrayList<>();
        String sql = "SELECT [RouteID],[RouteName],[StartLocation], [EndLocation], [Description], [Status] FROM tblRoutes WHERE [Status] = 1";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(sql);
                rs = ptm.executeQuery();
                while(rs.next()){
                    list.add(new Route(rs.getInt("RouteID"), 
                            rs.getString("RouteName"), 
                            locationDao.getLocationById(rs.getInt("StartLocation")), 
                            locationDao.getLocationById(rs.getInt("EndLocation")), 
                            rs.getString("Description"), 
                            rs.getBoolean("Status")));
                }
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
    public Route getRouteByStartLocationAndEndLocation(int start, int end) throws SQLException {
        String sql = "SELECT RouteID,RouteName,"
                + "StartLocation,EndLocation,[Description],[Status] "
                + "FROM tblRoutes "
                + "WHERE StartLocation = ? AND EndLocation = ?";
        
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setInt(1, start);
            ptm.setInt(2, end);
            rs = ptm.executeQuery();
            while (rs.next()) {
                 return new Route(rs.getInt("RouteID"), 
                        rs.getString("RouteName"), 
                        locationDao.getLocationById(rs.getInt("StartLocation")), 
                        locationDao.getLocationById(rs.getInt("EndLocation")),
                        rs.getString("Description"), 
                        rs.getBoolean("Status"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (conn != null) conn.close();
            if (ptm != null) ptm.close();
            if (rs != null) rs.close();
        } 
        return null;
    }
}
