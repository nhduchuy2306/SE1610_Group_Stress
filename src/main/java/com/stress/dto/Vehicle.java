
package com.stress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Vehicle {
    private String vehicleID;
    private String vehicleName;
    private String licensePlate;
    private int vehicleTypeID;
    private int status;
}
