
package com.stress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    public static final int UNAVAILABLE = 0;
    public static final int AVAILABLE = 1;
    
    private String seatID; 
    private int	price;
    private int	status;
    private Trip tripID;
}
