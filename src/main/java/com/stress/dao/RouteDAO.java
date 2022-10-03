
package com.stress.dao;

import com.stress.dto.Location;
import com.stress.dto.Route;
import java.sql.SQLException;
import java.util.List;


public interface RouteDAO {
    boolean addRoute(Route route) throws SQLException;
    boolean updateRoute(int RouteID, String RouteName, Location StartLocation, Location EndLocation, String Description, boolean Status) throws SQLException;
    boolean deleteRoute(String routeID) throws SQLException;
    List<Route> searchServiceByStartLocation(int startLocation) throws SQLException;
    List<Route> searchServiceByEndLocation(int endLocation) throws SQLException;
    Route getRouteByID(int routeID) throws SQLException;
    boolean checkDuplicateByID(int routeID) throws SQLException;
    List<Route> getAllRoute() throws SQLException;
}
