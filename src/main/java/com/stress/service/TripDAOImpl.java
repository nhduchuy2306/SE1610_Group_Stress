package com.stress.service;

import com.stress.dao.CityDAO;
import com.stress.dao.DriverDAO;
import com.stress.dao.RouteDAO;
import com.stress.dao.TripDAO;
import com.stress.dao.VehicleDAO;
import com.stress.dto.Trip;
import com.stress.utils.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TripDAOImpl implements TripDAO {

    private final RouteDAO routeDAO = new RouteDAOImpl();
    private final VehicleDAO vehicleDAO = new VehicleDAOImpl();
    private final DriverDAO driverDAO = new DriverDAOImpl();
    private final CityDAO cityDAO = new CityDAOImpl();

    @Override
    public boolean checkBookedTicket(String tripID) throws SQLException {
        String sql = "SELECT [TripName] AS [TripName] FROM tblTrips t INNER JOIN tblSeats s \n"
                + " ON t.TripID = s.TripID \n"
                + " WHERE t.TripID = ? AND s.[Status] = 1";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, tripID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String tripName = rs.getString("TripName");
                    if (!tripName.isBlank()) {
                        check = true;
                    }
                }

            }
        } catch (Exception e) {
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
    public boolean deleteTrip(String tripID) throws SQLException {
        String sql = "UPDATE tblTrips SET [Status] = 0 WHERE TripID = ?";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, tripID);
                check = ptm.executeUpdate() > 0;
            }
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
    public Trip getTripByID(String tripID) throws SQLException {
        String sql = "SELECT [TripID],[TripName], [StartDateTime], [StartTime], [Policy], [RouteID], "
                + "[VehicleID], [DriverID], [SeatRemain], [Status] FROM tblTrips "
                + "WHERE TripID = ?";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, tripID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    return new Trip(rs.getString("TripID"),
                            rs.getString("TripName"),
                            rs.getDate("StartDateTime"),
                            rs.getTime("StartTime"),
                            rs.getString("Policy"),
                            routeDAO.getRouteByID(rs.getInt("RouteID")),
                            vehicleDAO.getVehicleByID(rs.getString("VehicleID")),
                            driverDAO.getDriverByID(rs.getString("DriverID")),
                            rs.getInt("SeatRemain"),
                            rs.getInt("Status"));
                }
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return null;
    }

    @Override
    public boolean addTrip(Trip trip) throws SQLException {
        String sql = "INSERT INTO tblTrips([TripID],[TripName], [StartDateTime], [StartTime], [Policy], [RouteID], "
                + "[VehicleID], [DriverID], [SeatRemain], [Status]) VALUES(?,?,?,?,?,?,?,?,?,?)";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, trip.getTripID());
                ptm.setString(2, trip.getTripName());
                ptm.setDate(3, trip.getStartDateTime());
                ptm.setTime(4, trip.getStartTime());
                ptm.setString(5, trip.getPolicy());
                ptm.setInt(6, trip.getRoute().getRouteID());
                ptm.setString(7, trip.getVehicle().getVehicleID());
                ptm.setString(8, trip.getDriver().getDriverID());
                ptm.setInt(9, trip.getSeatRemain());
                ptm.setInt(10, trip.getStatus());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
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
    public List<Trip> getAllTrip() throws SQLException {
        List<Trip> list = new ArrayList<>();
        String sql = "SELECT [TripID],[TripName], [StartDateTime], [StartTime], [Policy], [RouteID], "
                + "[VehicleID], [DriverID], [SeatRemain], [Status] FROM tblTrips WHERE [Status] = 1";
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new Trip(rs.getString("TripID"),
                            rs.getString("TripName"),
                            rs.getDate("StartDateTime"),
                            rs.getTime("StartTime"),
                            rs.getString("Policy"),
                            routeDAO.getRouteByID(rs.getInt("RouteID")),
                            vehicleDAO.getVehicleByID(rs.getString("VehicleID")),
                            driverDAO.getDriverByID(rs.getString("DriverID")),
                            rs.getInt("SeatRemain"),
                            rs.getInt("Status")));
                }
            }
        } catch (Exception e) {
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    @Override
    public boolean updateTrip(Trip trip) throws SQLException {
        String sql = "UPDATE tblTrips SET [TripName] = ?, [StartDateTime] = ?, [StartTime] = ?, [Policy] = ?, [RouteID] = ?, "
                + "[VehicleID] = ?, [DriverID] = ?, [SeatRemain] = ?, [Status] = ? WHERE [TripID] = ?";
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, trip.getTripName());
                ptm.setDate(2, trip.getStartDateTime());
                ptm.setTime(3, trip.getStartTime());
                ptm.setString(4, trip.getPolicy());
                ptm.setInt(5, trip.getRoute().getRouteID());
                ptm.setString(6, trip.getVehicle().getVehicleID());
                ptm.setString(7, trip.getDriver().getDriverID());
                ptm.setInt(8, trip.getSeatRemain());
                ptm.setInt(9, trip.getStatus());
                ptm.setString(10, trip.getTripID());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
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
    public List<Trip> getAllTripByRouteAndStartDay(int routeID, String day) throws SQLException {
        String sql = "SELECT [TripID],[TripName], [StartDateTime],[StartTime],[Policy], [RouteID], "
                + "[VehicleID], [DriverID], [SeatRemain], [Status] FROM tblTrips "
                + "WHERE RouteID = ? AND StartDateTime = ?";
        List<Trip> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setInt(1, routeID);
                ptm.setString(2, day);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new Trip(rs.getString("TripID"),
                            rs.getString("TripName"),
                            rs.getDate("StartDateTime"),
                            rs.getTime("StartTime"),
                            rs.getString("Policy"),
                            routeDAO.getRouteByID(rs.getInt("RouteID")),
                            vehicleDAO.getVehicleByID(rs.getString("VehicleID")),
                            driverDAO.getDriverByID(rs.getString("DriverID")),
                            rs.getInt("SeatRemain"),
                            rs.getInt("Status")));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    @Override
    public List<Trip> getAllTripByStartEndLocationAndStartDay(String start, String end, String date)
            throws SQLException {
        String sql = "SELECT t.TripID,t.StartDateTime,t.StartTime,t.TripName,t.[Policy],t.RouteID,t.VehicleID,t.DriverID,t.SeatRemain,t.[Status]\n"
                + "FROM tblTrips t \n"
                + "INNER JOIN tblRoutes r\n"
                + "ON t.RouteID = r.RouteID AND t.StartDateTime = ?\n"
                + "WHERE StartLocation IN(SELECT LocationID FROM tblLocations WHERE CityID = ?)\n"
                + "AND EndLocation IN (SELECT LocationID FROM tblLocations WHERE CityID = ?)";
        List<Trip> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, date);
                ptm.setInt(2, cityDAO.getCityIDByName(start));
                ptm.setInt(3, cityDAO.getCityIDByName(end));
                rs = ptm.executeQuery();
                while (rs.next()) {
                    list.add(new Trip(rs.getString("TripID"),
                            rs.getString("TripName"),
                            rs.getDate("StartDateTime"),
                            rs.getTime("StartTime"),
                            rs.getString("Policy"),
                            routeDAO.getRouteByID(rs.getInt("RouteID")),
                            vehicleDAO.getVehicleByID(rs.getString("VehicleID")),
                            driverDAO.getDriverByID(rs.getString("DriverID")),
                            rs.getInt("SeatRemain"),
                            rs.getInt("Status")));
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }
    public static void main(String[] args) {
        TripDAOImpl tr = new TripDAOImpl();
        try {
            System.out.println(tr.checkBookedTicket("T0054"));
        } catch (SQLException ex) {
            Logger.getLogger(TripDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
