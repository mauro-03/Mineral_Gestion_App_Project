package com.mauro.mineral_gestion_app_project.model;

/**
 * Created by mauro on 10-05-18.
 * Model class, describe a LOCATION, where a mineral comme from
 */

public class Location {

    private int location_id;
    private String location_city;
    private String location_area;
    private String location_Country;

    public Location(){}

    public Location(String location_city, String location_area, String location_Country) {
        this.location_city = location_city;
        this.location_area = location_area;
        this.location_Country = location_Country;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getLocation_area() {
        return location_area;
    }

    public void setLocation_area(String location_area) {
        this.location_area = location_area;
    }

    public String getLocation_Country() {
        return location_Country;
    }

    public void setLocation_Country(String location_Country) {
        this.location_Country = location_Country;
    }
}
