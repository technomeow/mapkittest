package com.mapkit.test.pojo;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LastVar on 05.06.2015.
 */
public class Task{

    @Expose
    private Integer ID;
    @Expose
    private String title;
    @Expose
    private Long date;
    @Expose
    private String text;
    @Expose
    private String longText;
    @Expose
    private String durationLimitText;
    @Expose
    private Double price;
    @Expose
    private String locationText;
    @Expose
    private Location location;
    @Expose
    private Integer zoomLevel;
    @Expose
    private List<Price> prices = new ArrayList<Price>();
    @Expose
    private Boolean translation;

    //Getters/Setters

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLongText() {
        return longText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public String getDurationLimitText() {
        return durationLimitText;
    }

    public void setDurationLimitText(String durationLimitText) {
        this.durationLimitText = durationLimitText;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getLocationText() {
        return locationText;
    }

    public void setLocationText(String locationText) {
        this.locationText = locationText;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getZoomLevel() {
        return zoomLevel;
    }

    public void setZoomLevel(Integer zoomLevel) {
        this.zoomLevel = zoomLevel;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

    public Boolean getTranslation() {
        return translation;
    }

    public void setTranslation(Boolean translation) {
        this.translation = translation;
    }
}
