package com.aliguraras.buildpc.models;

import java.io.Serializable;

public class Computer implements Serializable {

    private GraphicsCard graphicsCard;
    private Motherboard motherboard;
    private RamModule ramModule;

    public Computer() {

    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public Motherboard getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        this.motherboard = motherboard;
    }

    public RamModule getRamModule() {
        return ramModule;
    }

    public void setRamModule(RamModule ramModule) {
        this.ramModule = ramModule;
    }

    public void deleteBuild(){
        motherboard = null;
        ramModule = null;
        graphicsCard = null;
    }
}
