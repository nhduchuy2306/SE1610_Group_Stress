
package com.stress.dao;

import com.stress.dto.Order;
import java.sql.SQLException;


public interface OrderDAO {
    Order getOderByID(String orderID) throws SQLException;
}
