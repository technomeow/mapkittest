package com.mapkit.test.pojo;

import com.google.gson.annotations.Expose;

/**
 * Created by LastVar on 05.06.2015.
 */
public class Price {
    @Expose
    private Double price;
    @Expose
    private String description;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
