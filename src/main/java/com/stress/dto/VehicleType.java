
package com.stress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleType {
    private int vehicleTypeID;
    private String vehicleTypeName;
    private int totalSeat;
}
