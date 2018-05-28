package fr.bikemanager.dto;

import fr.bikemanager.entity.Engine;

import java.io.Serializable;

public class EngineDto implements Serializable {

    private int id;

    private float oilQuantity;

    private String brand;

    private int enginePower;

    private int engineCylinder;

    public EngineDto() {

    }

    public EngineDto(Engine engine) {
        this.id = engine.getId();
        this.oilQuantity = engine.getOilQuantity();
        this.brand = engine.getBrand();
        this.enginePower = engine.getEnginePower();
        this.engineCylinder = engine.getEngineCylinder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getOilQuantity() {
        return oilQuantity;
    }

    public void setOilQuantity(float oilQuantity) {
        this.oilQuantity = oilQuantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getEngineCylinder() {
        return engineCylinder;
    }

    public void setEngineCylinder(int engineCylinder) {
        this.engineCylinder = engineCylinder;
    }
}
