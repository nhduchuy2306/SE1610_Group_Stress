
package com.stress.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver {
    private String driverID;
    private String driverName;	
    private Date DOB; 
    private String driverPicture;
    private String phoneNumber;
    private int status;
    
}
