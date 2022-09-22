
package com.stress.dao;

import com.stress.dto.Route;
import java.sql.SQLException;


public interface RouteDAO {
    boolean addRoute(Route route) throws SQLException;
    boolean updateRoute(Route route) throws SQLException;
    boolean deleteRoute(String routeID) throws SQLException;
}
