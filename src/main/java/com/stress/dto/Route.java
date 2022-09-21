
package com.stress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
    private String routeID;
    private String routeName;
    private String startLocation;
    private String endLocation;
    private String description;
    private boolean status;
}
