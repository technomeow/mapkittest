package com.mapkit.test.pojo;

import com.google.gson.annotations.Expose;

/**
 * Created by LastVar on 05.06.2015.
 */
public class Location {
    @Expose
    private Double lat;
    @Expose
    private Double lon;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}
