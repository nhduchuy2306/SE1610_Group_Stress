
package com.stress.service;

import com.stress.dao.OrderDAO;
import com.stress.dto.Order;
import java.sql.SQLException;

/**
 *
 * @author Huy
 */
public class OrderDAOImpl implements OrderDAO{

    @Override
    public Order getOderByID(String orderID) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
