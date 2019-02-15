package com.aliguraras.buildpc.models;

import java.io.Serializable;

public class Motherboard implements Serializable {

    private String brand;
    private String model;

    public Motherboard(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
