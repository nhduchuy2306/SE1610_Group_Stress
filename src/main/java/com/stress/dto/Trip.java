
package com.stress.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private String tripID;
    private String tripName;
    private Date startDateTime;
    private String policy;
    private int routeID;
    private String vehicleID;
    private String driverID;
    private int seatRemain;
    private int status;	
}
