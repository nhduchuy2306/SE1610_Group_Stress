
package com.stress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    public static final boolean UNAVAILABLE = false;
    public static final boolean AVAILABLE = true;
    private int locationID;
    private String locationName;
    private String Address;
    private int cityID;
    private boolean status;
}
