
package com.stress.dao;

import com.stress.dto.Route;
import java.sql.SQLException;
import java.util.List;


public interface RouteDAO {
    boolean addRoute(Route route) throws SQLException;
    boolean updateRoute(Route route) throws SQLException;

    boolean deleteRoute(String routeID) throws SQLException;

    List<Route> searchServiceByStartLocation(String startLocation) throws SQLException;
    List<Route> searchServiceByEndLocation(String endLocation) throws SQLException;

    


}
