/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stress.dto;

/**
 *
 * @author Huy
 */
public class Location {
    private String locationID;
    private String locationName;

    public Location() {
    }

    public Location(String locationID, String locationName) {
        this.locationID = locationID;
        this.locationName = locationName;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "Location{" + "locationID=" + locationID + ", locationName=" + locationName + '}';
    }
}
