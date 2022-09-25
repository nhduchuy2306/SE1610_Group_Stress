/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author MinhQuang
 */
@Data
@Getter
@Setter
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
