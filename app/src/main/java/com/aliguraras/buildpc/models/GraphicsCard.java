package com.aliguraras.buildpc.models;

import java.io.Serializable;

public class GraphicsCard implements Serializable {

    private String brand;
    private String model;
    private int sizeInGb;

    public GraphicsCard(String brand, String model, int sizeInGb) {
        this.brand = brand;
        this.model = model;
        this.sizeInGb = sizeInGb;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getSizeInGb() {
        return sizeInGb;
    }
}
