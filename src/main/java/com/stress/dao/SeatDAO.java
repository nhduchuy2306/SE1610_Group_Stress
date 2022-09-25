
package com.stress.dao;

import com.stress.dto.Seat;
import java.sql.SQLException;


public interface SeatDAO {
    Seat getSeatByID(String seatID) throws SQLException;
}
