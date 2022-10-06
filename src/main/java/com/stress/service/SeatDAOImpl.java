
package com.stress.service;

import com.stress.dao.SeatDAO;
import com.stress.dto.Seat;
import com.stress.dto.Trip;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huy
 */
public class SeatDAOImpl implements SeatDAO{

    @Override
    public Seat getSeatByID(String string) throws SQLException {
        return null;
    }
    
    private static List<String> creatSeatID(String tripID) throws SQLException{
        List<String> list = new ArrayList<>();
//        Trip trip = new TripDAOImpl().getTripByID(tripID);
//        int numOfRow = trip.getVehicle().getVehicleType().getTotalSeat()/4;
        int numOfRow = 7;
        char start = 'A';
        String seatID = "";
        int[] cols = {0,1,2,3,4,5};
        for(int i = 0; i < numOfRow; i++){
            start += i;
            for(int j = 1; j < cols.length; j++){
                seatID = "";
                if(i<numOfRow && j != 3){
                    seatID = seatID + start + "_" +cols[j];
                    list.add(seatID);
                }
                else if(i==numOfRow-1){
                    seatID = seatID + start + "_" +cols[j];
                    list.add(seatID);
                }
            }
            start = 'A';
        }
        return list;
    }

    @Override
    public boolean addSeat(String tripID) throws SQLException {
        
        return true;
    }
    public static void main(String[] args) {
        try {
            System.out.println(creatSeatID("").toString());
        } catch (SQLException ex) {
            Logger.getLogger(SeatDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
