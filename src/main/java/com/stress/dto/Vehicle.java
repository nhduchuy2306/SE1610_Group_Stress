
package com.stress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    public static final int ACTIVE = 1;
    public static final int ONGOING = 2;
    public static final int INACTIVE = 0;
    
    private String vehicleID;
    private String vehicleName;
    private String licensePlate;
    private VehicleType vehicleType;
    private int status;
}
