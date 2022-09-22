
package com.stress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    private int routeID;
    private String routeName;
    private int startLocation;
    private int endLocation;
    private String description;
    private boolean status;
}
